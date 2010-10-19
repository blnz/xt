// $Id: RawValueOfAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.Node;
import com.blnz.xsl.om.XSLException;
import com.blnz.xsl.expr.StringExpr;

/**
 * represents an "xsl:value-of" with disable-output-escaping='yes'
 */
class RawValueOfAction implements Action
{
    private StringExpr expr;
    private String attribute;

    /**
     * construct around the given StringExpr
     */
    RawValueOfAction(StringExpr expr)
    {
        this.expr = expr;

        // Huh??
        this.attribute = attribute;
    }

    /**
     * evaluate with the given context Node and
     * ProcessContext, sending the results to the given result
     */
    public void invoke(ProcessContext context, 
                       Node sourceNode, Result result) 
        throws XSLException
    {
        result.rawCharacters(expr.eval(sourceNode, context));
    }

}
