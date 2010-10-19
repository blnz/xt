// $Id: CharsAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 * character data
 */
class CharsAction implements Action
{
    private String chars;
    CharsAction(String chars)
    {
        this.chars = chars;
    }

    public void invoke(ProcessContext context, Node sourceNode, 
                       Result result) throws XSLException
    {
        result.characters(chars);
    }
}

