// $Id: FloorFunction.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class FloorFunction extends Function1 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr e) throws ParseException
    {
        final NumberExpr ne = e.makeNumberExpr();
        return new ConvertibleNumberExpr() {
                public double eval(Node node, ExprContext context)
		    throws XSLException 
		{
                    return Math.floor(ne.eval(node, context));
                }
            };
    }
}
