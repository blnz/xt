//

package com.blnz.xsl.om;

/**
 * allows for us to attach additional semantics, beyond that specified for XML, to Nodes in the parse tree
 */
public interface NodeExtension
{
    public Node getNode();
    public void setNode(Node n);
}
