// $Id: NodeIterator.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.om;

/**
 * represents a list of Nodes
 */
public interface NodeIterator 
{
    /**
     * return the next Node in the list
     */
    Node next() throws XSLException;
}
