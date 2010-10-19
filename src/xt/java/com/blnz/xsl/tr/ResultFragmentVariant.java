// $Id: ResultFragmentVariant.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.Variant;

/**
 *
 */
public interface ResultFragmentVariant extends Variant
{

    void append(Result result) throws XSLException;

    Node getTree(ProcessContext context) throws XSLException;
}
