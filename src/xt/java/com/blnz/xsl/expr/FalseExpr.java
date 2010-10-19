// $Id: FalseExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class FalseExpr extends ConvertibleBooleanExpr 
{
    public boolean eval(Node node, ExprContext context) 
    {
        return false;
    }
}
