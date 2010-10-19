// $Id: ElementTest.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * A compiled XPath expression (component)
 * tests a node for being an ELEMENT with a
 * given Name
 */
class ElementTest extends PathPatternBase 
{
    private final Name name;
    
    /**
     * construct with the Name to be tested
     */
    ElementTest(Name name) 
    {
        this.name = name;
    }

    /**
     * @return true if the node is an Element and has the
     *  Name we're testing
     */
    public boolean matches(Node node, ExprContext context) 
    {
        return (node.getType() == Node.ELEMENT &&
                name.equals(node.getName()));

    }

    /**
     * @return the Name to test
     */
    Name getMatchName() 
    { return name; }

    /**
     * @return om.Node.ELEMENT
     */
    byte getMatchNodeType() 
    { return Node.ELEMENT; }

    /**
     * @return 0
     */
    public int getDefaultPriority() 
    { return 0; }
}





