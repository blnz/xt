// $Id: Action.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 * the parsed representation of a stylesheet component.
 *  When evaluated (or invoked) with a ProcessContext
 *  and context Node, generates something which is
 * sent to a result
 */
interface Action
{
    void invoke(ProcessContext context, Node sourceNode, 
                Result result) throws XSLException;
}
