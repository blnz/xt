// $Id: NumberFunction.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NumberFunction extends FunctionOpt1 {
    ConvertibleExpr makeCallExpr(ConvertibleExpr e) throws ParseException {
        return e.makeNumberExpr();
    }
}
