// $Id: UnionExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
class UnionExpr extends ConvertibleNodeSetExpr 
{
    private final NodeSetExpr expr1;
    private final NodeSetExpr expr2;
    
    UnionExpr(NodeSetExpr expr1, NodeSetExpr expr2) 
    {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public NodeIterator eval(Node node, ExprContext context) throws XSLException 
    {
        return new UnionNodeIterator(expr1.eval(node, context),
                                     expr2.eval(node, context));
    }
}
