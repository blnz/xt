// $Id: TerminateXSLException.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

public class TerminateXSLException extends XSLException
{
    public TerminateXSLException(String detail, Node node)
    {
        super(detail, node);
    }
}
