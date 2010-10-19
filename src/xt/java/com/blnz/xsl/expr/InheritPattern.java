// $Id: InheritPattern.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

class InheritPattern implements Pattern {
    private Pattern p;

    InheritPattern(Pattern p) {
        this.p = p;
    }

    public boolean matches(Node node, ExprContext context) throws XSLException {
        do {
            if (p.matches(node, context))
                return true;
            node = node.getParent();
        } while (node != null);
        return false;
    }
}
