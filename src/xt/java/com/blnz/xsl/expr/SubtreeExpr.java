// $Id: SubtreeExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * descendants-or-self(node())/E when E has STAYS_IN_SUBTREE
 */
class SubtreeExpr extends ConvertibleNodeSetExpr 
{
    private final ConvertibleNodeSetExpr expr;

    SubtreeExpr(ConvertibleNodeSetExpr expr) 
    {
        this.expr = expr;
    }
    
    public NodeIterator eval(Node node, ExprContext context) throws XSLException 
    {
        return new UnionNodeIterator(expr.eval(node, context),
                                     new SequenceComposeNodeIterator(node.getChildren(),
                                                                     this,
                                                                     context));
    }
    
    int getOptimizeFlags() {
        return STAYS_IN_SUBTREE;
    }
}
