// $Id: AncestorOrSelfAxisExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * An XPath expression component representing
 * the ancestor-or-self axis
 */
class AncestorOrSelfAxisExpr extends ReverseAxisExpr
{
    /**
     * When evaluated, returns a Node iterator for
     * the context node and its ancestors
     */
    public NodeIterator eval(Node node, ExprContext context)
    {
        return new AncestorsOrSelfNodeIterator(node);
    }
}
