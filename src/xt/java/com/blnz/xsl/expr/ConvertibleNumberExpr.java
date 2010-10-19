// $Id: ConvertibleNumberExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

abstract class ConvertibleNumberExpr extends ConvertibleExpr implements NumberExpr
{

    ConvertibleNumberExpr makeNumberExpr()
    {
        return this;
    }

    ConvertibleBooleanExpr makePredicateExpr()
    {
        return new ConvertibleBooleanExpr() {
                public boolean eval(Node node, ExprContext context) throws XSLException {
                    return Converter.positionToBoolean(ConvertibleNumberExpr.this.eval(node, context),
                                                       context);
                }
            };
    }

    ConvertibleBooleanExpr makeBooleanExpr()
    {
        return new ConvertibleBooleanExpr() {
                public boolean eval(Node node, ExprContext context) throws XSLException {
                    return Converter.toBoolean(ConvertibleNumberExpr.this.eval(node, context));
                }
            };
    }

    ConvertibleVariantExpr makeVariantExpr()
    {
        return new ConvertibleVariantExpr() {
                public Variant eval(Node node, ExprContext context) throws XSLException {
                    return new NumberVariant(ConvertibleNumberExpr.this.eval(node, context));
                }
            };
    }

    ConvertibleStringExpr makeStringExpr()
    {
        return new ConvertibleStringExpr() {
                public String eval(Node node, ExprContext context) throws XSLException {
                    return Converter.toString(ConvertibleNumberExpr.this.eval(node, context));
                }
            };
    }
}
