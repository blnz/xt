// $Id: FilterExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * an expression that returns a NodeIterator of subset of the Nodes that match a given predicate
 */
class FilterExpr extends ConvertibleNodeSetExpr 
{
    private final ConvertibleNodeSetExpr expr;
    private final BooleanExpr predicate;

    FilterExpr(ConvertibleNodeSetExpr expr, BooleanExpr predicate) 
    {
        this.expr = expr;
        this.predicate = predicate;
    }

    public NodeIterator eval(Node node, ExprContext context) throws XSLException 
    {
        return new FilterNodeIterator(expr.eval(node, context),
                                      context,
                                      predicate);
    }

    /* OPT: if the expr is of the form position()=n,
       then SINGLE_LEVEL must be true */
    int getOptimizeFlags() 
    {
        return expr.getOptimizeFlags();
    }
}
