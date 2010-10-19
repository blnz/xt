// $Id: ChildAxisExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
class ChildAxisExpr extends AxisExpr
{
    public NodeIterator eval(Node node, ExprContext context)
    {
        return node.getChildren();
    }

    int getOptimizeFlags()
    {
        return STAYS_IN_SUBTREE | SINGLE_LEVEL;
    }
}
