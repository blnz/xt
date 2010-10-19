// $Id: CopyAction.java 99 2005-02-28 21:37:53Z blindsey $

package com.blnz.xsl.tr;

import com.blnz.xsl.om.*;

/**
 * <xsl:copy
 */
class CopyAction implements Action
{
    private Action content;

    CopyAction(Action content)
    {
        this.content = content;
    }

    /**
     *
     */
    public void invoke(ProcessContext context, 
                       Node sourceNode, 
                       Result result) throws XSLException
    {
        switch (sourceNode.getType()) {
        case Node.ROOT:
            content.invoke(context, sourceNode, result);
            break;

        case Node.TEXT:
            result.characters(sourceNode.getData());
            break;

        case Node.ATTRIBUTE:
            result.attribute(sourceNode.getName(), sourceNode.getData());
            break;

        case Node.PROCESSING_INSTRUCTION:
            result.processingInstruction(sourceNode.getName().toString(),
                                         sourceNode.getData());
            break;

        case Node.COMMENT:
            result.comment(sourceNode.getData());
            break;

        case Node.ELEMENT:
            result.startElement(sourceNode.getName(),
                                sourceNode.getNamespacePrefixMap());
            if (content != null) {
                content.invoke(context, sourceNode, result);
            }
            result.endElement(sourceNode.getName());
            break;
        }
    }
}
