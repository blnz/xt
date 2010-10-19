// $Id: ValueOfAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.StringExpr;

/**
 * xsl:value-of
 */
class ValueOfAction implements Action
{
    private StringExpr expr;
    private String attribute;
    
    ValueOfAction(StringExpr expr)
    {
        this.expr = expr;

        // what's this??
        this.attribute = attribute;
    }

    /**
     *
     */    
    public void invoke(ProcessContext context, Node sourceNode, 
                       Result result) 
        throws XSLException
    {
        result.characters(expr.eval(sourceNode, context));
    }

}
