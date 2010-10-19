// $Id: AttributeAxisExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NamespaceAxisExpr extends AxisExpr
{
    public NodeIterator eval(Node node, ExprContext context)
    {
        return node.getNamespaces();
    }

    int getOptimizeFlags()
    {
        return STAYS_IN_SUBTREE | SINGLE_LEVEL;
    }
    /* OPT: Implement compose for when the expr is a ParentAxis */
}
