// $Id: BindLocalVariableAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.VariantExpr;

/**
 * binds a variable to a name
 */
class BindLocalVariableAction implements Action
{
    private final Name name;
    private final VariantExpr expr;

    BindLocalVariableAction(Name name, VariantExpr expr)
    {
        this.name = name;
        this.expr = expr;
    }

    public void invoke(ProcessContext context, Node sourceNode, 
                       Result result) throws XSLException
    {
        context.bindLocalVariable(name, expr.eval(sourceNode, context));
    }
}
