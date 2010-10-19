// $Id: AddExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * a compiled XPath expression (component) that represents
 * the addition of two sub-expressions
 */
class AddExpr extends ConvertibleNumberExpr
{
    private transient final NumberExpr expr1;
    private transient final NumberExpr expr2;

    /**
     * construct with two NumberExpr(essions)
     */
    AddExpr(NumberExpr expr1, NumberExpr expr2)
    {
        super();
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    /**
     * evaluate to result of a double
     */
    public double eval(final Node node, final ExprContext context) 
        throws XSLException
    {
        return expr1.eval(node, context) + expr2.eval(node, context);
    }
}
