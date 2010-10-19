// $Id: LocalVariableRefExpr.java 112 2005-03-28 21:39:11Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
class LocalVariableRefExpr extends ConvertibleVariantExpr 
{
    private final Name name;
    
    LocalVariableRefExpr(Name name) 
    {
        this.name = name;
    }
    
    public Variant eval(Node node, ExprContext context) 
        throws XSLException 
    {
        return context.getLocalVariableValue(name);
    }
}
