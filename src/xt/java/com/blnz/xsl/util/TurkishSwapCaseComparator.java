// $Id: TurkishSwapCaseComparator.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.util;

class TurkishSwapCaseComparator extends SwapCaseComparator 
{

    TurkishSwapCaseComparator(Comparator cmp) 
    {
        super(cmp);
    }

    char swapCase(char c) 
    {
        switch (c) {
        case '\u0130': // dotted I
            return 'i';
        case '\u0131': // dotless i
            return 'I';
        case 'i':
            return '\u0130';
        case 'I':
            return '\u0131';
        }
        return super.swapCase(c);
    }
}
