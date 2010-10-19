// $Id: IntersectionNodeIterator.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

public class IntersectionNodeIterator implements NodeIterator {
    private NodeIterator iter1;
    private NodeIterator iter2;
    private Node node1;
    private Node node2;

    public IntersectionNodeIterator(NodeIterator iter1, NodeIterator iter2) throws XSLException {
        this.iter1 = iter1;
        this.iter2 = iter2;
        this.node1 = iter1.next();
        this.node2 = iter2.next();
    }

    public Node next() throws XSLException {
        while (node1 != null && node2 != null) {
            int cmp = node1.compareTo(node2);
            if (cmp == 0) {
                Node tem = node1;
                node1 = iter1.next();
                node2 = iter2.next();
                return tem;
            }
            if (cmp < 0)
                node1 = iter1.next();
            else
                node2 = iter2.next();
        }
        return null;
    }
}
