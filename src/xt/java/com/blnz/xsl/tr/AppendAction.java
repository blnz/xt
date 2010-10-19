// $Id: AppendAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import java.util.Vector;
import java.util.Enumeration;

/**
 *
 */
class AppendAction implements Action
{
    private Vector sequence = new Vector();

    public void invoke(ProcessContext context, 
                       Node sourceNode, Result result) throws XSLException
    {
        for (Enumeration en = sequence.elements();
             en.hasMoreElements();)
            ((Action)en.nextElement()).invoke(context, sourceNode, result);
    }

    void add(Action action)
    {
        sequence.addElement(action);
    }
}
  
