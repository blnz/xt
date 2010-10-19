// $Id: FollowingAxisExpr.java 109 2005-03-28 20:53:12Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.Node;
import com.blnz.xsl.om.NodeIterator;

/**
 *
 */
class FollowingAxisExpr extends AxisExpr 
{
    public NodeIterator eval(Node node, ExprContext context) 
    {
        return new FollowingNodeIterator(node);
    }
}
