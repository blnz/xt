// $Id: RawCharactersHandler.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.sax2;

/**
 * a SAX style event handler that receives raw characters events
 * for writing e.g. non XML output
 */
public interface RawCharactersHandler 
{
    void rawCharacters(String chars) throws org.xml.sax.SAXException;
}
