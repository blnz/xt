// $Id: UnbindLocalVariablesAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.VariantExpr;

/**
 *
 */
class UnbindLocalVariablesAction implements Action
{
    private final int n;

    UnbindLocalVariablesAction(int n)
    {
        this.n = n;
    }

    public void invoke(ProcessContext context, 
                       Node sourceNode, 
                       Result result)
    {
        context.unbindLocalVariables(n);
    }
}
