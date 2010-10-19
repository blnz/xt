// $Id: KeyPattern.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * represents an XSLT/XPath pattern of the form key('foo', 'bar')
 */
class KeyPattern extends PathPatternBase 
{
    private String _keyVal;
    private String _keyName;

    KeyPattern(String keyName, String keyVal) 
    {
        _keyName = keyName;
	_keyVal = keyVal;
    }

    /**
     * @return true if the given node is indexed with the given key
     * value in the named key
     */
    public boolean matches(Node node, ExprContext context) 
    {
	// FIXME: do something real
        return node.isId(_keyVal);
    }

    /**
     * @return om.Node.ALLTYPES
     */
    byte getMatchNodeType() 
    {
	// FIXME: matches anything, n'est ce pas?
        return Node.ALLTYPES;
    }

    /**
     *
     */
    public int getDefaultPriority() 
    { return 1; }
}


