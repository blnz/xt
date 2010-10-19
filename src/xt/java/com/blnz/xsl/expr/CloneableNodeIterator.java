// $Id: CloneableNodeIterator.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

public interface CloneableNodeIterator extends NodeIterator
{
    Object clone();
    // Bind variable references to the values, so that
    // the iterator is protected from mutatations in the
    // ExprContext.
    void bind() throws XSLException;
}
