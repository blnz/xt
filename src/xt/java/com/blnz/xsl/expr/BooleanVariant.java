// $Id: BooleanVariant.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * a boolean which can provide its value as a String, Number 
 * or Object
 */
public class BooleanVariant extends VariantBase 
{
    private final boolean b;

    public BooleanVariant(boolean b) 
    {
        this.b = b;
    }

    public String convertToString()
    {
        return Converter.toString(b);
    }

    public boolean convertToBoolean() 
    {
        return b;
    }

    public double convertToNumber() 
    {
        return Converter.toNumber(b);
    }

    public Object convertToObject() 
    {
        return new Boolean(b);
    }

    public boolean isBoolean() 
    { 
	return true; 
    }
}
