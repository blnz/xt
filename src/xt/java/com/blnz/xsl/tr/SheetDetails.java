// $Id: SheetDetails.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;
import com.blnz.xsl.expr.Variant;
import com.blnz.xsl.expr.ExtensionContext;

/**
 * provides access to the  additional information in the compiled
 * stylesheet that the implementation of the ProcessContext
 * needs to get at, but we don't need to share with other packages
 */
interface SheetDetails extends Sheet
{

    /**
     *
     */
    VariableInfo getGlobalVariableInfo(Name name);

    /**
     * obtain the collection of templates which may be
     * applied in a named Mode
     */
    TemplateRuleSet getModeTemplateRuleSet(Name modeName);

    /**
     * obtain the definition of the named key
     */
    KeyDefinition getKeyDefinition(Name keyName);

    /**
     * return the value of the named system property
     */
    Variant getSystemProperty(Name name);

    /**
     *
     */
    ExtensionContext createExtensionContext(String namespace) 
        throws XSLException;

    /**
     * top level attribute set definition
     */
    Action getAttributeSet(Name name);

    /**
     *
     */
    boolean haveNamespaceAliases();

    /**
     *
     */
    String getNamespaceAlias(String ns);
}
