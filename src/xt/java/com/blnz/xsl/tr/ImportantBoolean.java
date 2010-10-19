// $Id: ImportantBoolean.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

final class ImportantBoolean
{
    private final boolean b;
    private Importance imp;

    ImportantBoolean(boolean b, Importance imp)
    {
        this.b = b;
        this.imp = imp;
    }

    public Importance getImportance()
    {
        return imp;
    }

    public boolean getBoolean()
    {
        return b;
    }
}
