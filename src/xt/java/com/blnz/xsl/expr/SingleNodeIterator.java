// $Id: SingleNodeIterator.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

public class SingleNodeIterator implements NodeIterator {
    private Node node;
    public SingleNodeIterator(Node node) {
        this.node = node;
    }
    public Node next() {
        Node tem = node;
        node = null;
        return tem;
    }
}
