// $Id: StringFunction.java 122 2005-04-05 01:22:51Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class StringFunction extends FunctionOpt1 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr e) throws ParseException 
    {
        return e.makeStringExpr();
    }
}
