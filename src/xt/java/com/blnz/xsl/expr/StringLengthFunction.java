// $Id: StringLengthFunction.java 114 2005-03-29 00:06:49Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class StringLengthFunction extends FunctionOpt1 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr e) 
    {
        final StringExpr se = e.makeStringExpr();
        return new ConvertibleNumberExpr() {
                public double eval(Node node, ExprContext context) throws XSLException {
                    return stringLength(se.eval(node, context));
                }
            };
    }

    private final static boolean isLowSurrogate(char c) {
        return (c & 0xFC00) == 0xD800;
    }

    private final static int stringLength(String s) {
        int n = s.length();
        int len = n;
        for (int i = 0; i < n; i++) {
            if (isLowSurrogate(s.charAt(i)))
                --len;
        }
        return len;
    }
}
