// $Id: RootExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * an XPath expression (component) that evaluates
 * a sub-expression with a document root Node as 
 * the contextNode
 */
class RootExpr extends ConvertibleNodeSetExpr 
{
    private final NodeSetExpr expr;
    
    /**
     * construct with a sub-expression
     */
    RootExpr(NodeSetExpr expr) 
    {
        this.expr = expr;
    }

    /**
     * evaluate the sub-expression with the context node's
     * root node
     */
    public NodeIterator eval(Node node, 
                             ExprContext context) throws XSLException 
    {
        return expr.eval(node.getRoot(), context);
    }
}
