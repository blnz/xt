// $Id: LiteralExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class LiteralExpr extends ConvertibleStringExpr {
    private final String literal;

    LiteralExpr(String literal) {
        this.literal = literal;
    }

    public String eval(Node node, ExprContext context) {
        return literal;
    }

    public String constantValue() {
        return literal;
    }
}
