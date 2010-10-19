// $Id: SystemPropertyFunction.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * implements the system-property() function, XSLT 1.0, section 12.4
 */
class SystemPropertyFunction implements Function 
{

    public ConvertibleExpr makeCallExpr(ConvertibleExpr e[], Node exprNode)
        throws ParseException 
    {

        if (e.length != 1) {
            throw new ParseException("expected one argument");
	}

        final StringExpr se = e[0].makeStringExpr();
        final NamespacePrefixMap prefixMap = exprNode.getNamespacePrefixMap();

        return new ConvertibleVariantExpr() {
                public Variant eval(Node node, ExprContext context) throws XSLException 
		{
                    return context.getSystemProperty(prefixMap.expandAttributeName(se.eval(node,
											   context), 
										   node));
                }
            };
    }
}
