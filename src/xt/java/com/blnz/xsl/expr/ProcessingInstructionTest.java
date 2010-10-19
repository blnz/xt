// $Id: ProcessingInstructionTest.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class ProcessingInstructionTest extends PathPatternBase 
{
    private final Name name;

    ProcessingInstructionTest(Name name) 
    {
        this.name = name;
    }

    public boolean matches(Node node, ExprContext context) 
    {
        return (name.equals(node.getName())
                && node.getType() == Node.PROCESSING_INSTRUCTION);
    }

    Name getMatchName() 
    { return name; }

    byte getMatchNodeType() 
    { return Node.PROCESSING_INSTRUCTION; }

    public int getDefaultPriority() 
    { return 0; }
}
