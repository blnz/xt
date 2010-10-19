// $Id: ExprNumberAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.NumberExpr;
import com.blnz.xsl.conv.NumberListFormat;

/**
 *
 */
class ExprNumberAction implements Action
{
    private NumberExpr expr;
    private NumberListFormatTemplate formatTemplate;

    ExprNumberAction(NumberExpr expr, NumberListFormatTemplate formatTemplate)
    {
        this.expr = expr;
        this.formatTemplate = formatTemplate;
    }

    public void invoke(ProcessContext context, Node node, Result result) 
        throws XSLException
    {
        NumberListFormat format = formatTemplate.instantiate(context, node);
        result.characters(format.getPrefix(0));
        result.characters(format.formatNumber(0,
                                              Math.round((float)expr.eval(node, context))));
        result.characters(format.getSuffix());
    }
}
