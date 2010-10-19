// $Id: AxisExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

abstract class AxisExpr extends ConvertibleNodeSetExpr
{
    ConvertibleNodeSetExpr makeFilterExpr(ConvertibleNodeSetExpr expr,
                                          BooleanExpr predicate) 
    {
        return new FilterExpr(expr, predicate);
    }

    ConvertibleNodeSetExpr makeDocumentOrderExpr(ConvertibleNodeSetExpr expr) 
    {
        return expr;
    }
}
