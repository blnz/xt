// $Id: DivideExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class DivideExpr extends ConvertibleNumberExpr 
{
    private final NumberExpr expr1;
    private final NumberExpr expr2;

    DivideExpr(NumberExpr expr1, NumberExpr expr2) 
    {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public double eval(Node node, ExprContext context) throws XSLException 
    {
        return expr1.eval(node, context) / expr2.eval(node, context);
    }
}
