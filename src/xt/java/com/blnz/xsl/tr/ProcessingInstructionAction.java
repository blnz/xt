// $Id: ProcessingInstructionAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.StringExpr;

/**
 * <xsl:processing-instruction
 */
class ProcessingInstructionAction implements Action
{
    private StringExpr nameExpr;
    private Action content;

    ProcessingInstructionAction(StringExpr nameExpr, Action content)
    {
        this.nameExpr = nameExpr;
        this.content = content;
    }

    public void invoke(ProcessContext context, Node sourceNode,
                       Result result) 
        throws XSLException
    {
        String name = nameExpr.eval(sourceNode, context);
        StringResult s = new StringResult(result);
        content.invoke(context, sourceNode, s);
        result.processingInstruction(name, s.toString());
    }
}
