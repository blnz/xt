// $Id: ExtensionHandler.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import java.net.URL;

import com.blnz.xsl.om.XSLException;
import com.blnz.xsl.expr.ExtensionContext;

/**
 * for extension functions -- i think
 */
public interface ExtensionHandler
{

    /**
     *
     */
    ExtensionContext createContext(String namespace) throws XSLException;

    /**
     *
     */
    Object wrapResultFragmentVariant(ResultFragmentVariant frag) 
        throws XSLException;
}
