package com.blnz.xsl.om;

/**
 *
 */
public interface NodeExtensionFactory
{
    /**
     */
    public NodeExtension createElementEx (String tag);

    /**
     * Returns an element which may be specialized to support application
     * specific behaviors as associated with the specified namespace.
     */
    public NodeExtension createElementEx (String uri, String tag);
}
