// $Id: AppendExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.Node;
import com.blnz.xsl.om.XSLException;


/**
 * Represents the concatenation of two String Expressions
 */
class AppendExpr extends ConvertibleStringExpr
{
    private StringExpr expr1;
    private StringExpr expr2;

    /**
     * construct with two XPath expressions which evaluate
     * to Strings
     */
    AppendExpr(StringExpr expr1, StringExpr expr2)
    {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    /**
     * evaluate each of the two sub-expressions with the given
     * context Node and given context, return the concatenation
     * of the results of each evaluation
     */ 
    public String eval(Node node, ExprContext context) throws XSLException
    {
        return expr1.eval(node, context) + expr2.eval(node, context);
    }
}
