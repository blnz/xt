// $Id: Function.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * all functions have the method: "makeCallExpr( ... ) "
 */
interface Function 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr[] args, Node exprNode) 
	throws ParseException;
}
