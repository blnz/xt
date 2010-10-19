// $Id: NodeTestExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
class NodeTestExpr extends ConvertibleNodeSetExpr 
{
    private final Pattern nodeTest;
    private final ConvertibleNodeSetExpr expr;

    NodeTestExpr(ConvertibleNodeSetExpr expr, Pattern nodeTest) 
    {
        this.expr = expr;
        this.nodeTest = nodeTest;
    }

    public NodeIterator eval(Node node, final ExprContext context) 
        throws XSLException 
    {
        final NodeIterator iter = expr.eval(node, context);
        return new NodeIterator() {
                public Node next() throws XSLException {
                    for (;;) {
                        Node tem = iter.next();
                        if (tem == null)
                            break;
                        if (nodeTest.matches(tem, context))
                            return tem;
                    }
                    return null;
                }
            };
    }

    int getOptimizeFlags() 
    {
        return expr.getOptimizeFlags();
    }

    Pattern getChildrenNodePattern() 
    {
        if (expr.getClass() == ChildAxisExpr.class)
            return nodeTest;
        return null;
    }
}
