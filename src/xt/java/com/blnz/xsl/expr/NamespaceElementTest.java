// $Id: NamespaceElementTest.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NamespaceElementTest extends PathPatternBase
{
    private final String ns;

    NamespaceElementTest(String ns)
    {
        this.ns = ns;
    }

    public boolean matches(Node node, ExprContext context)
    {
        return node.getType() == Node.ELEMENT && ns.equals(node.getName().getNamespace());
    }

    byte getMatchNodeType() 
    { return Node.ELEMENT; }

    public int getDefaultPriority() 
    { return -1; }
}
