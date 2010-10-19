// $Id: StringVariant.java 118 2005-03-29 19:27:34Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 *
 */
public class StringVariant extends VariantBase 
{
    private final String str;
    
    public StringVariant(String str) 
    {
        this.str = str;
    }

    public String convertToString()
    {
        return str;
    }

    public boolean convertToBoolean() 
    {
        return Converter.toBoolean(str);
    }

    public double convertToNumber() 
    {
        return Converter.toNumber(str);
    }

    public Object convertToObject() 
    {
        return str;
    }

    public boolean isString()
    { 
        return true; 
    }
}
