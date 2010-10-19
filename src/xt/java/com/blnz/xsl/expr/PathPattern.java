// $Id: PathPattern.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * a compiled XPath expression which has an
 * XSLT match priority
 */
public interface PathPattern extends Pattern 
{
    /**
     * priority when used in XSLT template match pattern
     */
    int getDefaultPriority();
}
