// $Id: GreaterThanEqualsRelation.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

class GreaterThanEqualsRelation extends NumericRelation {
    boolean relate(double d1, double d2) {
        return d1 >= d2;
    }
}
