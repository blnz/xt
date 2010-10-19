// $Id: NodeSetVariant.java 122 2005-04-05 01:22:51Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
class NodeSetVariant extends VariantBase 
{
    private final NodeIterator iter;
    
    NodeSetVariant(NodeIterator iter) {
        this.iter = iter;
    }

    public NodeIterator convertToNodeSet() {
        return iter;
    }

    public Object convertToObject() {
        return iter;
    }

    public String convertToString() throws XSLException {
        return Converter.toString(iter);
    }

    public boolean convertToBoolean() throws XSLException {
        return Converter.toBoolean(iter);
    }

    public double convertToNumber() throws XSLException {
        return Converter.toNumber(iter);
    }

    public Variant makePermanent() throws XSLException {
        return new PermanentNodeSetVariant(iter);
    }

    public boolean isNodeSet() { return true; }

}
