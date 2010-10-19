// $Id: NotFunction.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NotFunction extends Function1 {
    ConvertibleExpr makeCallExpr(ConvertibleExpr e) {
        final BooleanExpr be = e.makeBooleanExpr();
        return new ConvertibleBooleanExpr() {
                public boolean eval(Node node, ExprContext context) throws XSLException {
                    return !be.eval(node, context);
                }
            };
    }
}
