// $Id: UniqueNodeIterator.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/*
 * Remove duplicates. iter is assumed to be in document order. 
 */
class UniqueNodeIterator implements NodeIterator {
    private NodeIterator iter;
    private Node lastNode = null;

    UniqueNodeIterator(NodeIterator iter) 
    {
        this.iter = iter;
    }

    public Node next() throws XSLException 
    {
        // loop till we find a node that isn't the same as the last one
        for (;;) {
            Node tem = iter.next();
            if (tem == null)
                break;
            if (!tem.equals(lastNode))
                return lastNode = tem;
        }
        return null;
    }
}
