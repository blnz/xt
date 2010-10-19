// $Id: Engine.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import java.io.IOException;
import java.net.URL;

/**
 * An engine, compiles a stylesheet
 */
public interface Engine
{
    /**
     *
     */
    LoadContext getSheetLoadContext();

    /**
     *
     */
    Sheet createSheet(Node node) throws IOException, XSLException;

    /**
     *
     */
    Sheet createSheet(Node node, 
                      ActionDebugTarget debugger) 
        throws IOException, XSLException;

    /**
     *
     */
    NameTable getNameTable();
}
