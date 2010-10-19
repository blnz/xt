// $Id: NamespaceTest.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NamespaceTest implements Pattern 
{
    private final String ns;

    NamespaceTest(String ns) {
        this.ns = ns;
    }

    public boolean matches(Node node, ExprContext context) {
        return ns.equals(node.getName().getNamespace());
    }
}
