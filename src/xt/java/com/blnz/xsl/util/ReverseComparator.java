// $Id: ReverseComparator.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.util;

public class ReverseComparator implements Comparator 
{
    private Comparator cmp;

    public ReverseComparator(Comparator cmp) 
    {
        this.cmp = cmp;
    }

    public int compare(Object o1, Object o2) 
    {
        return -cmp.compare(o1, o2);
    }
}
