// $Id: EngineImpl.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.Node;
import com.blnz.xsl.om.Name;
import com.blnz.xsl.om.NameTable;
import com.blnz.xsl.om.NameTableImpl;
import com.blnz.xsl.om.XSLException;

import java.io.IOException;
import java.net.URL;

/**
 * compiles a stylesheet from a (XSLT D)OM
 */
public class EngineImpl extends NameTableImpl 
    implements Engine, LoadContext
{
    final private XMLProcessor parser;
    final private ExtensionHandler extensionHandler;
    final private Name XSL_TEXT;
    private ActionDebugTarget _debugger = null;

    /**
     * we'll keep track of the loader/processor for sheet creation time
     */
    public EngineImpl(XMLProcessor parser, 
                      ExtensionHandler extensionHandler)
    {
        this.parser = parser;
        this.extensionHandler = extensionHandler;
        XSL_TEXT = createName("xsl:text", SheetImpl.XSL_NAMESPACE);
    }

    /**
     * complies the stylesheet from the parsed OM
     */
    public Sheet createSheet(Node node) throws IOException, XSLException
    {
        return new SheetImpl(node, parser, extensionHandler, this, this);
    }

    /**
     * complies the stylesheet from the parsed OM providing a debugger
     */
    public Sheet createSheet(Node node,
                             ActionDebugTarget debugger) 
        throws IOException, XSLException
    {
        _debugger = debugger;
        return new SheetImpl(node, parser, extensionHandler, this, this);
    }

    public boolean getStripSource(Name elementTypeName)
    {
        return !XSL_TEXT.equals(elementTypeName);
    }

    public boolean getIncludeComments()
    {
        return false;
    }

    public boolean getIncludeProcessingInstructions()
    {
        return false;
    }

    public LoadContext getSheetLoadContext()
    {
        return this;
    }

    public NameTable getNameTable()
    {
        return this;
    }

    public ActionDebugTarget getDebugger()
    {
        return _debugger;
    }
}
