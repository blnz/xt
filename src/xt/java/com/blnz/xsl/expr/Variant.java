// $Id: Variant.java 122 2005-04-05 01:22:51Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
public interface Variant 
{
    /**
     *
     */
    String convertToString() throws XSLException;

    /**
     *
     */
    boolean convertToBoolean() throws XSLException;

    /**
     *
     */
    Variant makePermanent() throws XSLException;

    /**
     *
     */
    NodeIterator convertToNodeSet() throws XSLException;

    /**
     *
     */
    double convertToNumber() throws XSLException;

    /**
     *
     */
    Object convertToObject() throws XSLException;

    /**
     *
     */
    boolean convertToPredicate(ExprContext context) throws XSLException;

    /**
     *
     */
    boolean isBoolean();

    /**
     *
     */
    boolean isNumber();

    /**
     *
     */
    boolean isString();

    /**
     *
     */
    boolean isNodeSet();

    /**
     *
     */
    Node getBaseNode();		// for base URI; null if none

}
