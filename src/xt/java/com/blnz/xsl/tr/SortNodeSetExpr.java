// $Id: SortNodeSetExpr.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.NodeSetExpr;
import com.blnz.xsl.expr.ExprContext;
import com.blnz.xsl.expr.NodeListSorter;

/**
 * sorts a node list before returning them from
 * a nested expression
 */
public class SortNodeSetExpr implements NodeSetExpr
{
    private NodeSetExpr expr;
    private ComparatorTemplate comparatorTemplate;

    public SortNodeSetExpr(NodeSetExpr expr,
                           ComparatorTemplate comparatorTemplate)
    {
        this.expr = expr;
        this.comparatorTemplate = comparatorTemplate;
    }

    public NodeIterator eval(Node node, ExprContext context) throws XSLException
    {
        try {
            return NodeListSorter.sort(expr.eval(node, context),
                                       comparatorTemplate.instantiate(node, context));
        }
        catch (UncheckedXSLException e) {
            throw e.getXSLException();
        }
    }

}
