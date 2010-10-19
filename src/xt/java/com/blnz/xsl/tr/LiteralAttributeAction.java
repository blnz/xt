// $Id: LiteralAttributeAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 *
 */
class LiteralAttributeAction implements Action
{
    private Name name;
    private String value;

    LiteralAttributeAction(Name name, String value)
    {
        this.name = name;
        this.value = value;
    }

    public void invoke(ProcessContext context, Node sourceNode,
                       Result result)
        throws XSLException
    {
        result.attribute(context.unaliasName(name), value);
    }
}
