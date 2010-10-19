// $Id: ResultFragmentExpr.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.Variant;
import com.blnz.xsl.expr.VariantExpr;
import com.blnz.xsl.expr.ExprContext;

/**
 *
 */
class ResultFragmentExpr implements VariantExpr
{
    final private Action action;
    final private Node stylesheetNode;
    final private ExtensionHandler extensionHandler;

    ResultFragmentExpr(Action action,
                       Node stylesheetNode,
                       ExtensionHandler extensionHandler)
    {
        this.action = action;
        this.stylesheetNode = stylesheetNode;
        this.extensionHandler = extensionHandler;
    }

    public Variant eval(Node node, ExprContext context)
    {
        return new ActionResultFragmentVariant(action,
                                               stylesheetNode,
                                               extensionHandler,
                                               node,
                                               ((ProcessContext)context).createMemento());
    }
}
