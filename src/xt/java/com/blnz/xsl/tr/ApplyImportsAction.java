// $Id: ApplyImportsAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 *
 */
class ApplyImportsAction implements Action
{
    public void invoke(ProcessContext context, 
                       Node sourceNode, Result result) throws XSLException
    {
        context.applyImports(sourceNode, result);
    }
}
