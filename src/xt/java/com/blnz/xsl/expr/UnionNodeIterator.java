// $Id: UnionNodeIterator.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

public class UnionNodeIterator implements NodeIterator {
    private NodeIterator iter1;
    private NodeIterator iter2;
    private Node node1;
    private Node node2;

    public UnionNodeIterator(NodeIterator iter1, NodeIterator iter2) throws XSLException {
        this.iter1 = iter1;
        this.iter2 = iter2;
        this.node1 = iter1.next();
        this.node2 = iter2.next();
    }

    public Node next() throws XSLException {
        if (node1 == null) {
            Node tem = node2;
            node2 = iter2.next();
            return tem;
        }
        if (node2 == null) {
            Node tem = node1;
            node1 = iter1.next();
            return tem;
        }
        int cmp = node1.compareTo(node2);
        if (cmp == 0) {
            Node tem = node1;
            node1 = iter1.next();
            node2 = iter2.next();
            return tem;
        }
        if (cmp < 0) {
            Node tem = node1;
            node1 = iter1.next();
            return tem;
        }
        else {
            Node tem = node2;
            node2 = iter2.next();
            return tem;
        }
    }
}
