// $Id: CharsActionDebug.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 * character data
 */
class CharsActionDebug extends CharsAction
{


    private ActionDebugTarget _target;
    private String _templateIDHook;
    private Node _sheetNode;

    CharsActionDebug(
                     ActionDebugTarget target, 
                     Node sheetNode,
                     String templateIDHook,
                     String chars)
    {
       super(chars);

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
        super.invoke(context, sourceNode, _target);

        _target.endAction(_sheetNode, sourceNode, this);
    }
}
