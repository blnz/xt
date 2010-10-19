package com.blnz.xsl.sax2;

/** 
 * receives comment events from a parse
*/
public interface CommentHandler 
{
    /**
     * recieve notification that a comment has been encountered
     * in the parse
     */
    void comment(String contents) throws org.xml.sax.SAXException;
}
