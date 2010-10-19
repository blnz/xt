// $Id: VariantExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
public interface VariantExpr 
{
    Variant eval(Node node, ExprContext context) throws XSLException;
}
