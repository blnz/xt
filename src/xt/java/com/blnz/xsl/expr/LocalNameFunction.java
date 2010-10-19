// $Id: LocalNameFunction.java 116 2005-03-29 00:57:07Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class LocalNameFunction extends FunctionOpt1 
{
    ConvertibleExpr makeCallExpr(ConvertibleExpr expr) throws ParseException 
    {
        final NodeSetExpr nse = expr.makeNodeSetExpr();
        return new ConvertibleStringExpr() 
            {
                public String eval(Node node, ExprContext context) throws XSLException 
                {
                    node = nse.eval(node, context).next();
                    if (node != null) {
                        Name name = node.getName();
                        if (name != null) {
                            return name.getLocalPart();
                        }
                    }
                    return "";
                }
            };
    }
}
