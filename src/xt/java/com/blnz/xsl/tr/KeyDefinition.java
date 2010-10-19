// $Id: KeyDefinition.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.expr.StringExpr;
import com.blnz.xsl.expr.TopLevelPattern;

import com.blnz.xsl.om.*;

/**
 * represents the top-level element xsl:key which defines
 *  a named lookup table for nodes
 * XSLT 1.0 section 12.2
 */
public class KeyDefinition
{

    private Name _name;
    private TopLevelPattern _matchPattern;
    private StringExpr _useExpression;
    
    /**
     * construct with the name of the key, the match pattern
     * for finding nodes to be indexed, and a useExpression for
     * determining the node's value for the index lookup
     */
    public KeyDefinition(Name name, TopLevelPattern matchPattern,
			 StringExpr useExpression)
    {
	_name = name;
	_matchPattern = matchPattern;
	_useExpression = useExpression;
    }

    public TopLevelPattern getMatchPattern()
    {
	return _matchPattern;
    }

    public StringExpr getUseExpression()
    {
	return _useExpression;
    }

    public Name getName()
    {
	return _name;
    }
}
