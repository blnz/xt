// $Id: OutputContentHandler.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.sax2;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.util.Properties;
import java.io.IOException;

/**
 * a SAX2 ContentHandler that serializes to a Destination
 * and requires some initialization
 */
public interface OutputContentHandler extends ContentHandler
{
    /**
     * Initialize the handler with the targetDestination and
     * output method Properties (from xsl:output + calling environment)
     */
    ContentHandler init(Destination dest, Properties outputMethodProperties) 
        throws SAXException, IOException;
}

