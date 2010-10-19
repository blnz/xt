// $Id: UncheckedXSLException.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.XSLException;

class UncheckedXSLException extends RuntimeException
{
    private XSLException e;

    UncheckedXSLException(XSLException e)
    { this.e = e; }

    XSLException getXSLException()
    { return e; }
}
