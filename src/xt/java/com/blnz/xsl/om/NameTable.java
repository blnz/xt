// $Id: NameTable.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.om;

/**
 * constructs (or obtains) Names for qName/namespace pairs
 */
public interface NameTable 
{
    /**
     * obtain a Name with no namespace
     */
    Name createName(String localPart);

    /**
     * obtain a name in the given namespace
     */
    Name createName(String qName, String namespace);

    /**
     * obtain an empty NamespacePrefixMap
     */
    NamespacePrefixMap getEmptyNamespacePrefixMap();
}
