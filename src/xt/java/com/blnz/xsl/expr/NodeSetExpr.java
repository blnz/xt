// $Id: NodeSetExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * A NodeSetExpr (compiled XPath), when evaluated with a contextNode
 * and an ExpressionContext, yields a NodeIterator
 */
public interface NodeSetExpr 
{
    /**
     * evaluate the expression with a contextNode
     * and ExprContext
     */
    NodeIterator eval(Node node, 
                      ExprContext context) 
        throws XSLException;
}
