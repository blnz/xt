// $Id: DocumentOrderComparator.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.util.Comparator;
import com.blnz.xsl.om.Node;

/**
 *
 */
class DocumentOrderComparator implements Comparator 
{
    public int compare(Object obj1, Object obj2) 
    {
        return ((Node)obj1).compareTo((Node)obj2);
    }
}
