// $Id: DescendantsOrSelfNodeIterator.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * walks an entire (sub)-tree, excluding attributes
 */
public class DescendantsOrSelfNodeIterator implements NodeIterator 
{
    private int depth;
    private NodeIterator iter;
    private Node cur;
    public DescendantsOrSelfNodeIterator(Node node) 
    {
        depth = 0;
        iter = node.getChildren();
        cur = node;
    }

    public Node next() throws XSLException 
    {
        Node tem = cur;
        for (;;) {
            Node node = iter.next();
            if (node != null) {
                ++depth;
                cur = node;
                iter = node.getChildren();
                return tem;
            }
            else {
                if (depth == 0) {
                    break;
		}
                depth--;
                iter = cur.getFollowingSiblings();
                cur = cur.getParent();
            }
        }
        cur = null;
        return tem;
    }
}
