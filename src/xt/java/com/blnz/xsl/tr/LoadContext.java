// $Id: LoadContext.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.Name;

/**
 * maintains a list of a few options for how a XMLProcessor constructs
 * an object model
 */
public interface LoadContext
{
    /**
     * white space handling
     */
    boolean getStripSource(Name elementTypeName);

    /**
     * include comment nodes?
     */
    boolean getIncludeComments();

    /**
     * include processing instructions?
     */
    boolean getIncludeProcessingInstructions();

    /**
     * are we instrumenting this transformer?
     */
    ActionDebugTarget getDebugger();
}
