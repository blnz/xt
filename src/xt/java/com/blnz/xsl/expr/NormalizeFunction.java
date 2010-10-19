// $Id: NormalizeFunction.java 122 2005-04-05 01:22:51Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;
import java.util.StringTokenizer;

class NormalizeFunction extends FunctionOpt1 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr expr) throws ParseException 
    {
        final StringExpr se = expr.makeStringExpr();
        return new ConvertibleStringExpr() {
                public String eval(Node node, ExprContext context) throws XSLException {
                    return normalize(se.eval(node, context));
                }
            };
    }
    
    private static String normalize(String s) 
    {
        StringBuffer buf = new StringBuffer();
        for (StringTokenizer e = new StringTokenizer(s); e.hasMoreElements();) {
            if (buf.length() > 0)
                buf.append(' ');
            buf.append((String)e.nextElement());
        }
        return buf.toString();
    }
}
