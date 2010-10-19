// $Id: ComparatorTemplate.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.util.Comparator;
import com.blnz.xsl.expr.ExprContext;

/**
 *
 */
interface ComparatorTemplate
{
    Comparator instantiate(Node node, ExprContext context) throws XSLException;
}
