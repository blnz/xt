// $Id: UseAttributeSetAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 *
 */
class UseAttributeSetAction implements Action
{
    private final Name name;

    UseAttributeSetAction(Name name)
    {
        this.name = name;
    }

    public void invoke(ProcessContext context, Node sourceNode,
                       Result result)
        throws XSLException
    {
        context.useAttributeSet(name, sourceNode, result);
    }
}
