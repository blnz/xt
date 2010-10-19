// $Id: ForEachAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.NodeSetExpr;

/**
 * <xsl:for-each
 */
class ForEachAction implements Action
{
    private NodeSetExpr expr;
    private Action action;

    ForEachAction(NodeSetExpr expr, Action action)
    {
        this.expr = expr;
        this.action = action;
    }

    public void invoke(ProcessContext context, Node sourceNode, 
                       Result result) 
        throws XSLException
    {
        context.invoke(expr.eval(sourceNode, context), action, result);
    }
}

