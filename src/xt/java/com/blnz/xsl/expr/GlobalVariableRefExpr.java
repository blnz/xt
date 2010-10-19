// $Id: GlobalVariableRefExpr.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class GlobalVariableRefExpr extends ConvertibleVariantExpr {
    private final Name name;
    private final Node node;

    GlobalVariableRefExpr(Name name, Node node) {
        this.name = name;
        this.node = node;
    }

    public Variant eval(Node sourceNode, ExprContext context) throws XSLException {
        Variant value = context.getGlobalVariableValue(name);
        if (value != null) {
            return value;
        }
        throw new XSLException("variable \"" + name + "\" not defined",
                               node);
    }

    public Name getName() { return name; }
}
