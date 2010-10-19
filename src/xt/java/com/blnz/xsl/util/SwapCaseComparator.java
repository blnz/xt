// $Id: SwapCaseComparator.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.util;

class SwapCaseComparator implements Comparator 
{
    private Comparator cmp;

    SwapCaseComparator(Comparator cmp) 
    {
        this.cmp = cmp;
    }

    public int compare(Object o1, Object o2) 
    {
        return cmp.compare(swapCase((String)o1), swapCase((String)o2));
    }

    private String swapCase(String str) 
    {
        char buf[] = new char[str.length()];
        str.getChars(0, buf.length, buf, 0);
        for (int i = 0; i < buf.length; i++)
            buf[i] = swapCase(buf[i]);
        return new String(buf);
    }

    char swapCase(char c) 
    {
        char uc = Character.toUpperCase(c);
        if (c != uc)
            return uc;
        return Character.toLowerCase(c);
    }
}
