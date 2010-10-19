// $Id: StringExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.Node;
import com.blnz.xsl.om.XSLException;

/**
 * an XPath expression which evaluates to a String
 */
public interface StringExpr 
{
    /**
     * evaluate with the given contextNode and context
     * @return the resulting String
     */
    String eval(Node node, ExprContext context) 
        throws XSLException;

    /**
     *
     */
    String constantValue();
}
