// $Id: NodeConstantExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NodeConstantExpr extends ConvertibleNodeSetExpr {
    private final Node node;

    NodeConstantExpr(Node node) {
        this.node = node;
    }

    public NodeIterator eval(Node contextNode, ExprContext context) {
        return new SingleNodeIterator(node);
    }
}
