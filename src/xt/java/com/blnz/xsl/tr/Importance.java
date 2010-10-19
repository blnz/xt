// $Id: Importance.java 113 2005-03-28 21:52:49Z blindsey $

package com.blnz.xsl.tr;

final class Importance
{
    private int n;

    private Importance(int n)
    {
        this.n = n;
    }

    static public Importance create()
    {
        return new Importance(0);
    }

  
    public void set(int n)
    {
        this.n = n;
    }

    public int compareTo(Importance p)
    {
        return this.n - p.n;
    }

}
