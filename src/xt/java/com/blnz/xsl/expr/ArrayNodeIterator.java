// $Id: ArrayNodeIterator.java 122 2005-04-05 01:22:51Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
class ArrayNodeIterator implements NodeIterator
{
    private int i;
    private int len;
    private Node[] nodes;


    /**
     *
     */
    ArrayNodeIterator(Node[] nodes, int start, int end)
    {
        this.nodes = nodes;
        this.len = end;
        this.i = start;
    }

    public Node next()
    {
        if (i == len) {
            return null;
	}
        return nodes[i++];
    }
}
