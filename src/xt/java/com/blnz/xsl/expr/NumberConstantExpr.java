// $Id: NumberConstantExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NumberConstantExpr extends ConvertibleNumberExpr {
    private final double number;

    NumberConstantExpr(double number) {
        this.number = number;
    }

    public double eval(Node node, ExprContext context) {
        return number;
    }
}
