// $Id: Function2.java 109 2005-03-28 20:53:12Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.Node;

/**
 *
 */
abstract class Function2 implements Function 
{
    abstract ConvertibleExpr makeCallExpr(ConvertibleExpr e1, ConvertibleExpr e2) 
        throws ParseException;

    public ConvertibleExpr makeCallExpr(ConvertibleExpr e[], Node exprNode) 
        throws ParseException 
    {
        if (e.length != 2) {
            throw new ParseException("expected two arguments");
        }
        return makeCallExpr(e[0], e[1]);
    }
}
