// $Id: BindLocalParamAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.VariantExpr;
import com.blnz.xsl.expr.Variant;

/**
 * binds a local parameter to a name
 * <xsl:param />
 */
class BindLocalParamAction implements Action 
{
    private final Name name;
    private final VariantExpr expr;

    BindLocalParamAction(Name name, VariantExpr expr)
    {
        this.name = name;
        this.expr = expr;
    }

    public void invoke(ProcessContext context, Node sourceNode, 
                       Result result) throws XSLException
    {
        Variant value = context.getParam(name); 

        // was it passed in the context?
        if (value == null) {
            // no, use the default value
            value = expr.eval(sourceNode, context);
        }
        context.bindLocalVariable(name, value);
    }
}
