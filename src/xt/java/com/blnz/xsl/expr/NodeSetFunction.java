// $Id: NodeSetFunction.java 116 2005-03-29 00:57:07Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class NodeSetFunction extends Function1 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr e) 
    {
        final VariantExpr ve = e.makeVariantExpr();
        return new ConvertibleNodeSetExpr() 
            {
                public NodeIterator eval(Node node, ExprContext context)
                    throws XSLException 
                {
                    
                    Variant v = ve.eval(node, context);
                    Node nd = context.getTree(v);
                    if (nd != null) {
                        return new SingleNodeIterator(nd); 
                    }
                    return v.convertToNodeSet();
                }
            };
    }
}
