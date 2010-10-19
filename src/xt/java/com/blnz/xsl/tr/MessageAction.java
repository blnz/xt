// $Id: MessageAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 * <xsl:message
 */
class MessageAction implements Action
{
    private Action content;

    MessageAction(Action content)
    {
        this.content = content;
    }

    public void invoke(ProcessContext context, Node sourceNode,
                       Result result) throws XSLException
    {
        StringResult s = new StringResult(result);
        content.invoke(context, sourceNode, s);
        result.message(sourceNode, s.toString());
    }
}
