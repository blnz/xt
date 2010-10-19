// $Id: ExtensionContext.java 109 2005-03-28 20:53:12Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.XSLException;
import com.blnz.xsl.om.Node;

/**
 *
 */
public interface ExtensionContext 
{
    /**
     *
     */
    boolean available(String name);

    /**
     *
     */
    Object call(String name, Node currentNode, Object[] args) 
        throws XSLException;
}
