// $Id: AncestorAxisExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * an XPath expression component representing
 * an ancestor axis
 */
class AncestorAxisExpr extends ReverseAxisExpr
{
    /**
     * when evaluated, return a NodeIterator of parent and its 
     * ancestors
     */
    public NodeIterator eval(Node node, ExprContext context)
    {
        return new AncestorsOrSelfNodeIterator(node.getParent());
    }
}
