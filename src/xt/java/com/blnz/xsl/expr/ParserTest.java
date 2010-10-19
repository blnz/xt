// $Id: ParserTest.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class ParserTest {
    static public void main(String args[]) throws XSLException {
        ExprParser.parseStringExpr(null, args[0], new EmptyVariableSet());
    }
}
