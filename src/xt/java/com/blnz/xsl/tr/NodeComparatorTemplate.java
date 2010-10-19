// $Id: NodeComparatorTemplate.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.util.Comparator;
import com.blnz.xsl.expr.ExprContext;
import com.blnz.xsl.expr.StringExpr;

class NodeComparatorTemplate implements ComparatorTemplate
{
    private final Comparator cmp;
    private final StringExpr expr;

    NodeComparatorTemplate(Comparator cmp, StringExpr expr) 
    {
        this.cmp = cmp;
        this.expr = expr;
    }

    public Comparator instantiate(Node node, final ExprContext context)
    {
        return new Comparator() {
                public int compare(Object o1, Object o2) {
                    return cmp.compare(getKey(o1), getKey(o2));
                }
                private String getKey(Object obj) {
                    try {
                        return expr.eval((Node)obj, context);
                    }
                    catch (XSLException e) {
                        throw new UncheckedXSLException(e);
                    }
                }
            };
    }
}
