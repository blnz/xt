// $Id: FalseFunction.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * a function of 0 arguments that returns false
 */
class FalseFunction extends Function0 
{
    ConvertibleExpr makeCallExpr() 
    {
        return new FalseExpr();
    }
}
