// $Id: ObjectVariant.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class ObjectVariant extends VariantBase 
{
    private final Object obj;

    ObjectVariant(Object obj)
    {
        this.obj = obj;
    }

    public Object convertToObject() 
    {
        return obj;
    }

    public String convertToString() 
    {
        if (obj == null) {
            return "";
	}
        return obj.toString();
    }

    public boolean convertToBoolean() 
    {
        return obj != null;
    }
}
