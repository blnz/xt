// $Id: ProcessAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.NodeSetExpr;

/**
 * apply-templates!
 */
class ProcessAction extends ParamAction
{
    private NodeSetExpr expr;
    private Name modeName;
    
    ProcessAction(NodeSetExpr expr, Name modeName)
    {
        this.expr = expr;
        this.modeName = modeName;
    }

    public void invoke(ProcessContext context, Node sourceNode, 
                       Result result)
        throws XSLException
    {
        context.process(expr.eval(sourceNode, context),
                        modeName,
                        getParamNames(),
                        getParamValues(sourceNode, context),
                        result);
    }
}
