// $Id: ExprNumberActionDebug.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.NumberExpr;
import com.blnz.xsl.conv.NumberListFormat;

/**
 *
 */
class ExprNumberActionDebug extends ExprNumberAction
{


    private ActionDebugTarget _target;
    private String _templateIDHook;
    private Node _sheetNode;

    ExprNumberActionDebug(
                          ActionDebugTarget target, 
                          Node sheetNode,
                          String templateIDHook,
                          NumberExpr expr, 
                          NumberListFormatTemplate formatTemplate)
    {
        super(expr, formatTemplate);

        _target = target;
        _sheetNode = sheetNode;
        _templateIDHook = templateIDHook;
    }


    /**
     *
     */    
    public void invoke(ProcessContext context, Node sourceNode, 
                       Result result) 
        throws XSLException
    {
        _target.startAction(_sheetNode, sourceNode, this);

        super.invoke(context, sourceNode, result);

        _target.endAction(_sheetNode, sourceNode, this);
    }
}
