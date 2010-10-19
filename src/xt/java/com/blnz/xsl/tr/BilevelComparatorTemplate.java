// $Id: BilevelComparatorTemplate.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.util.Comparator;
import com.blnz.xsl.util.BilevelComparator;
import com.blnz.xsl.expr.ExprContext;

class BilevelComparatorTemplate implements ComparatorTemplate
{
    private final ComparatorTemplate t1;
    private final ComparatorTemplate t2;
    BilevelComparatorTemplate(ComparatorTemplate t1, ComparatorTemplate t2)
    {
        this.t1 = t1;
        this.t2 = t2;
    }

    public Comparator instantiate(Node node, ExprContext context) throws XSLException
    {
        return new BilevelComparator(t1.instantiate(node, context),
                                     t2.instantiate(node, context));
    }
}
