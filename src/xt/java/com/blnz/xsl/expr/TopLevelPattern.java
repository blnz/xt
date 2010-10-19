// $Id: TopLevelPattern.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * an XPath top level match pattern?
 */
public interface TopLevelPattern extends Pattern 
{
    /**
     * may represent an "or" grouping, so
     *  we allow them to be broken
     * out and dealt with separately
     */
    PathPattern[] getAlternatives();
}
