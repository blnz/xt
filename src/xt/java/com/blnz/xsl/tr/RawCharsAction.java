// $Id: RawCharsAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 *
 */
class RawCharsAction implements Action
{
    private String chars;

    RawCharsAction(String chars)
    {
        this.chars = chars;
    }

    /**
     *
     */
    public void invoke(ProcessContext context, 
                       Node sourceNode, Result result) 
        throws XSLException
    {
        result.rawCharacters(chars);
    }
}

