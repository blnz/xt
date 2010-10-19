// $Id: StringRelationalExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class StringRelationalExpr extends ConvertibleBooleanExpr 
{
    private final Relation rel;
    private final StringExpr expr1;
    private final StringExpr expr2;
    
    StringRelationalExpr(Relation rel, StringExpr expr1, StringExpr expr2) 
    {
        this.rel = rel;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean eval(Node node, ExprContext context) throws XSLException 
    {
        return rel.relate(expr1.eval(node, context),
                          expr2.eval(node, context));
    }
}
