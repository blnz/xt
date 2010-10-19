// $Id: SafeNodeIterator.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.om;

/**
 * represents a list of Nodes -- the next() function promises to not throw an exception
 */
public interface SafeNodeIterator extends NodeIterator 
{
    /**
     * get the next Node in the list, and don't throw any Exception
     */
    Node next();
}
