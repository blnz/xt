// $Id: StartsWithFunction.java 122 2005-04-05 01:22:51Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class StartsWithFunction extends Function2 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr e1, ConvertibleExpr e2) throws ParseException {
        final StringExpr se1 = e1.makeStringExpr();
        final StringExpr se2 = e2.makeStringExpr();
        return new ConvertibleBooleanExpr() {
                public boolean eval(Node node, ExprContext context) throws XSLException {
                    return se1.eval(node, context).startsWith(se2.eval(node, context));
                }
            };
    }
}
