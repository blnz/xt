// $Id: NamespaceAttributeTest.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NamespaceAttributeTest extends PathPatternBase
{
    private final String ns;

    NamespaceAttributeTest(String ns)
    {
        this.ns = ns;
    }

    public boolean matches(Node node, ExprContext context)
    {
        return node.getType() == Node.ATTRIBUTE && ns.equals(node.getName().getNamespace());
    }

    byte getMatchNodeType() { return Node.ATTRIBUTE; }

    public int getDefaultPriority() { return -1; }
}
