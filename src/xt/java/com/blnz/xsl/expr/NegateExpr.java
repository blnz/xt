// $Id: NegateExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NegateExpr extends ConvertibleNumberExpr {
    private final NumberExpr expr;

    NegateExpr(NumberExpr expr) {
        this.expr = expr;
    }

    public double eval(Node node, ExprContext context) throws XSLException {
        return -expr.eval(node, context);
    }
}
