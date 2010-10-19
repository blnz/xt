// $Id: ElementOrAttributeTest.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class ElementOrAttributeTest implements Pattern 
{
    private final Name name;

    ElementOrAttributeTest(Name name) 
    {
        this.name = name;
    }

    public boolean matches(Node node, ExprContext context) 
    {
        return (name.equals(node.getName())
                && node.getType() != Node.PROCESSING_INSTRUCTION);
    }
}
