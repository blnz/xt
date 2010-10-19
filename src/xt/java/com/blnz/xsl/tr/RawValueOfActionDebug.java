// $Id: RawValueOfActionDebug.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.Node;
import com.blnz.xsl.om.XSLException;
import com.blnz.xsl.expr.StringExpr;

/**
 * represents an "xsl:value-of" with disable-output-escaping='yes'
 */
class RawValueOfActionDebug extends RawValueOfAction
{


    private ActionDebugTarget _target;
    private String _templateIDHook;
    private Node _sheetNode;

    /**
     * construct around the given StringExpr
     */
    RawValueOfActionDebug(
                          ActionDebugTarget target, 
                          Node sheetNode,
                          String templateIDHook,
                          StringExpr expr)
    {
        super(expr);

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
