// $Id: TemplateAttributeAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.StringExpr;

/**
 *
 */
class TemplateAttributeAction implements Action
{
    private Name name;
    private StringExpr value;

    TemplateAttributeAction(Name name, StringExpr value)
    {
        this.name = name;
        this.value = value;
    }

    public void invoke(ProcessContext context, Node sourceNode, Result result)
        throws XSLException
    {
        result.attribute(context.unaliasName(name),
                         value.eval(sourceNode, context));
    }
}
