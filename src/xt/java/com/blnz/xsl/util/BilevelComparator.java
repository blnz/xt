// $Id: BilevelComparator.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.util;

public class BilevelComparator implements Comparator
{
    private Comparator cmp1;
    private Comparator cmp2;

    public BilevelComparator(Comparator cmp1, Comparator cmp2)
    {
        this.cmp1 = cmp1;
        this.cmp2 = cmp2;
    }

    public int compare(Object o1, Object o2) 
    {
        int res = cmp1.compare(o1, o2);
        if (res != 0)
            return res;
        return cmp2.compare(o1, o2);
    }
}
