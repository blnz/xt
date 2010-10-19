// $Id: SingleLevelNumberActionDebug.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.Pattern;
import com.blnz.xsl.conv.NumberListFormat;

/**
 *
 */
class SingleLevelNumberActionDebug extends SingleLevelNumberAction
{

    private ActionDebugTarget _target;
    private String _templateIDHook;
    private Node _sheetNode;

    SingleLevelNumberActionDebug(
                                 ActionDebugTarget target, 
                                 Node sheetNode,
                                 String templateIDHook,
                                 Pattern count, Pattern from,
                                 NumberListFormatTemplate formatTemplate)
    {
        super(count, from, formatTemplate);

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
