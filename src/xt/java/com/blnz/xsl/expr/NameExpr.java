// $Id: NameExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

public interface NameExpr {
    Name eval(Node node, ExprContext context) throws XSLException;
}
