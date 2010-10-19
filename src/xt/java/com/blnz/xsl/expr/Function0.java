// $Id: Function0.java 109 2005-03-28 20:53:12Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.Node;

/**
 * base class for all functions taking no arguments
 */
abstract class Function0 implements Function
{
    
    abstract ConvertibleExpr makeCallExpr() 
        throws ParseException;
    
    public ConvertibleExpr makeCallExpr(ConvertibleExpr e[], Node exprNode) 
	throws ParseException 
    {
        if (e.length != 0) {
            throw new ParseException("expected zero arguments");
	}
        return makeCallExpr();
    }
}
