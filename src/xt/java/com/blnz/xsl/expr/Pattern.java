// $Id: Pattern.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * an XPATH (XSLT) match pattern
 */
public interface Pattern 
{
    /**
     * return true if the given node matches this pattern
     * when evaluated in the given ExpressionContext
     */
    boolean matches(Node node, ExprContext context) 
        throws XSLException;
}
