// $Id: AddVariableSet.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.VariableSet;

class AddVariableSet implements VariableSet
{
    private final Name var;
    private final VariableSet set;

    AddVariableSet(Name var, VariableSet set)
    {
        this.var = var;
        this.set = set;
    }

    public boolean contains(Name name)
    {
        return name.equals(var) || set.contains(name);
    }
}
