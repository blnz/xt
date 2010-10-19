// $Id: IntersectionFunction.java 109 2005-03-28 20:53:12Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class IntersectionFunction extends Function2 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr e1, ConvertibleExpr e2)
        throws ParseException 
    {
        final NodeSetExpr nse1 = e1.makeNodeSetExpr();
        final NodeSetExpr nse2 = e2.makeNodeSetExpr();
        return new ConvertibleNodeSetExpr() {
                public NodeIterator eval(Node node, ExprContext context) 
                    throws XSLException {
                    return new IntersectionNodeIterator(nse1.eval(node, context),
                                                        nse2.eval(node, context));
                }
            };
    }
}
