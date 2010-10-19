// $Id: ComposeExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;
import com.blnz.xsl.om.*;

/**
 *
 */
class IfExpr extends ConvertibleVariantExpr
{
    private final BooleanExpr _test;
    private final VariantExpr _expr1;
    private final VariantExpr _expr2;

    /**
     * construct with a test and two sub-expressions
     */
    IfExpr(BooleanExpr test,
           VariantExpr expr1, 
           VariantExpr expr2) 
    {
        this._test = test;
        this._expr1 = expr1;
        this._expr2 = expr2;
    }
    
    /**
     * evaluate with a context node and an expression context
     */
    public Variant eval(Node node, 
                        ExprContext context) 
        throws XSLException 
    {
        
        if (_test.eval(node, context)) {
            return _expr1.eval(node, context);
        } else {
            return _expr2.eval(node, context);
        }

    }

}
