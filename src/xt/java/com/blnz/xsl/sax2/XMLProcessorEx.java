// $Id: XMLProcessorEx.java 97 2005-02-28 21:18:32Z blindsey $

package com.blnz.xsl.sax2;

import com.blnz.xsl.om.XSLException;
import com.blnz.xsl.om.Node;
import com.blnz.xsl.om.NameTable;
import com.blnz.xsl.tr.XMLProcessor;
import com.blnz.xsl.tr.LoadContext;

import org.xml.sax.InputSource;
import org.xml.sax.ErrorHandler;

import java.io.IOException;

/**
 * extended public interface for an XMLProcessor, which loads an XML
 *  source into our own  DOM-like structure
 */
public interface XMLProcessorEx extends XMLProcessor
{
    /**
     * @param source the input to our parser
     * @param documentIndex so we can distinguish between nodes in different docs
     * @param context ??
     * @param nameTable we intern names to avoid wasting menmory
     */
    Node load(InputSource source, int documentIndex, LoadContext context,
              NameTable nameTable)
        throws IOException, XSLException;


    /**
     *
     */
    public SAXTwoOMBuilder getConfiguredOMBuilder(String systemID, 
                                                 int documentIndex, 
                                                 LoadContext context,
                                                 NameTable nameTable);

    
    /**
     * @param errorHandler a SAX ErrorHandler where we report parse errors
     */
    void setErrorHandler(ErrorHandler errorHandler);
}
