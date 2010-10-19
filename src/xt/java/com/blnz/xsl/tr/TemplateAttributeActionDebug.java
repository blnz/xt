// $Id: TemplateAttributeActionDebug.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.StringExpr;

/**
 *
 */
class TemplateAttributeActionDebug extends TemplateAttributeAction
{


    private ActionDebugTarget _target;
    private String _templateIDHook;
    private Node _sheetNode;

    TemplateAttributeActionDebug(
                                 ActionDebugTarget target, 
                                 Node sheetNode,
                                 String templateIDHook,
                                 Name name, StringExpr value)
    {
        super(name, value);

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
