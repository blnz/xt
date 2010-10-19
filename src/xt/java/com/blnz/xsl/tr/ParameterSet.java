// $Id: ParameterSet.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 * a place to obtain run-time parameters from the
 *  execution environment
 */
public interface ParameterSet
{
    Object getParameter(Name name);
}
