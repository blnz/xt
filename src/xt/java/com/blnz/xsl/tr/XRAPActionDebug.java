// $Id: XRAPActionDebug.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

import com.blnz.xsl.expr.StringExpr;

import com.blnz.xsl.sax2.MultiNamespaceResult;
import com.blnz.xsl.sax2.SaxFilterMaker;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.ParserAdapter;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.xml.sax.XMLFilter;

/**
 * Invokes an XRAP processor
 */
class XRAPActionDebug extends XRAPAction
{

    private ActionDebugTarget _target;
    private String _templateIDHook;
    private Node _sheetNode;

    /**
     *
     */
    XRAPActionDebug(                             
                    ActionDebugTarget target, 
                    Node sheetNode,
                    String templateIDHook,
                    NamespacePrefixMap nsMap, 
                    Action content)
    {
        super(nsMap, content);
        _target = target;
        _sheetNode = sheetNode;
        _templateIDHook = templateIDHook;

    }

    /**
     *
     */
    public void invoke(ProcessContext context, 
                       Node sourceNode,
                       Result result) throws XSLException
    {
        super.invoke(context, sourceNode, result);
    }

}
