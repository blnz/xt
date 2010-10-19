// $Id: UnparsedEntityURIFunction.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class UnparsedEntityURIFunction extends Function1 {
    ConvertibleExpr makeCallExpr(ConvertibleExpr expr) throws ParseException {
        final StringExpr se = expr.makeStringExpr();
        return new ConvertibleStringExpr() {
                public String eval(Node node, ExprContext context) throws XSLException {
                    String uri = node.getUnparsedEntityURI(se.eval(node, context));
                    if (uri == null)
                        return "";
                    return uri;
                }
            };
    }
}
