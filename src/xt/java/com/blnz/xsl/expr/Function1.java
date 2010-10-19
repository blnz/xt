// $Id: Function1.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.Node;

/**
 * base class for all functions taking one arguments
 */
abstract class Function1 implements Function 
{
    abstract ConvertibleExpr makeCallExpr(ConvertibleExpr e) throws ParseException;

    public ConvertibleExpr makeCallExpr(ConvertibleExpr e[], Node exprNode) 
	throws ParseException 
    {
        if (e.length != 1) {
            throw new ParseException("expected one argument");
	}
        return makeCallExpr(e[0]);
    }
}
