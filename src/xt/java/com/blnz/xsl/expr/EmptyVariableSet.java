// $Id: EmptyVariableSet.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

public class EmptyVariableSet implements VariableSet 
{
    public boolean contains(Name name) 
    {
        return false;
    }
}
