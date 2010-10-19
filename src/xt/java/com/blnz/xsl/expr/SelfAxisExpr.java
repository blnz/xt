// $Id: SelfAxisExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class SelfAxisExpr extends AxisExpr 
{
    public NodeIterator eval(Node node, ExprContext context) 
    {
        return new SingleNodeIterator(node);
    }

    int getOptimizeFlags() 
    {
        return STAYS_IN_SUBTREE|SINGLE_LEVEL;
    }

    ConvertibleNodeSetExpr compose(ConvertibleNodeSetExpr expr) 
    {
        return expr;
    }
}
