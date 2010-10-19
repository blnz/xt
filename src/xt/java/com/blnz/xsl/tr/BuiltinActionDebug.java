// $Id: BuiltinActionDebug.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 *
 */
class BuiltinActionDebug extends BuiltinAction
{

    private ActionDebugTarget _target;
    private String _templateIDHook;
    private Node _sheetNode;

    BuiltinActionDebug(
                       ActionDebugTarget target, 
                       Node sheetNode,
                       String templateIDHook,
                       Name modeName)
    {
        super(modeName);

        _target = target;
        _sheetNode = sheetNode;
        _templateIDHook = templateIDHook;

    }

    BuiltinActionDebug(
                       ActionDebugTarget target, 
                       Node sheetNode,
                       String templateIDHook
                       )
    {
        super();

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
