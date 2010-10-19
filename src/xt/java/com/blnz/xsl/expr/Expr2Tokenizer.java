// $Id: ExprTokenizer.java 96 2005-02-28 21:07:29Z blindsey $

package com.blnz.xsl.expr;

import com.blnz.xsl.om.*;

/**
 * lexical analyser for XPath 2.0
 * @see http://www.w3c.org/TR/xpath
 */
class Expr2Tokenizer 
{
    //
    // The tokens
    //

    // end of string being tokenized
    static final int TOK_EOF = 0;

    // a qName
    static final int TOK_QNAME = TOK_EOF + 1;

    // "*" (wildcard) ?
    static final int TOK_STAR = TOK_QNAME + 1;

    // "foo:*" ?
    static final int TOK_NAME_COLON_STAR = TOK_STAR + 1;

    // "@" (attribute axis specifier)
    static final int TOK_AT = TOK_NAME_COLON_STAR + 1;

    // "." (node self)
    static final int TOK_DOT = TOK_AT + 1;

    // ".." parent axis
    static final int TOK_DOT_DOT = TOK_DOT + 1;

    // "comment("
    static final int TOK_COMMENT_LPAR = TOK_DOT_DOT + 1;

    // "processing-instruction(" ??
    static final int TOK_PROCESSING_INSTRUCTION_LPAR = TOK_COMMENT_LPAR + 1;

    // "text("
    static final int TOK_TEXT_LPAR = TOK_PROCESSING_INSTRUCTION_LPAR + 1;

    // "node("
    static final int TOK_NODE_LPAR = TOK_TEXT_LPAR + 1;

    // "*" ?? same as star?
    static final int TOK_MULTIPLY = TOK_NODE_LPAR + 1;

    // "("
    static final int TOK_LPAR = TOK_MULTIPLY + 1;

    // ")"
    static final int TOK_RPAR = TOK_LPAR + 1;

    // "["
    static final int TOK_LSQB = TOK_RPAR + 1;

    // "]"
    static final int TOK_RSQB = TOK_LSQB + 1;

    //  'xxx ' | " xxx "
    static final int TOK_LITERAL = TOK_RSQB + 1;

    // [0-9].?[0-9]*
    static final int TOK_NUMBER = TOK_LITERAL + 1;

    // e.g.  "ancestor-or-self::"
    static final int TOK_AXIS = TOK_NUMBER + 1;

    // "foo("
    static final int TOK_FUNCTION_LPAR = TOK_AXIS + 1;

    // ??  maybe: "colonized name(" ??
    static final int TOK_CNAME_LPAR = TOK_FUNCTION_LPAR + 1;

    // "$foo"
    static final int TOK_VARIABLE_REF = TOK_CNAME_LPAR + 1;

    // "/"
    static final int TOK_SLASH = TOK_VARIABLE_REF + 1;

    // "//"  
    static final int TOK_SLASH_SLASH = TOK_SLASH + 1;

    // "|"
    static final int TOK_VBAR = TOK_SLASH_SLASH + 1;

    // ","
    static final int TOK_COMMA = TOK_VBAR + 1;

    // "+"
    static final int TOK_PLUS = TOK_COMMA + 1;

    // "-"
    static final int TOK_MINUS = TOK_PLUS + 1;

    // "="
    static final int TOK_EQUALS = TOK_MINUS + 1;

    // "!+"
    static final int TOK_NOT_EQUALS = TOK_EQUALS + 1;

    // ">"
    static final int TOK_GT = TOK_NOT_EQUALS + 1;

    // "<"
    static final int TOK_LT = TOK_GT + 1;

    // ">="
    static final int TOK_GTE = TOK_LT + 1;

    // "<="
    static final int TOK_LTE = TOK_GTE + 1;

    // "and"
    static final int TOK_AND = TOK_LTE + 1;

    // "or"  (why is this different from TOK_VBAR?)
    static final int TOK_OR = TOK_AND + 1;

    // "mod"
    static final int TOK_MOD = TOK_OR + 1;

    // "div"
    static final int TOK_DIV = TOK_MOD + 1;

    // "idiv"
    static final int TOK_IDIV = TOK_DIV + 1;

    // "if"
    static final int TOK_IF_LPAR = TOK_IDIV + 1;

    // "then"
    static final int TOK_THEN = TOK_IF_LPAR + 1;

    // "else"
    static final int TOK_ELSE = TOK_THEN + 1;

    // some
    static final int TOK_SOME = TOK_ELSE + 1;

    // every
    static final int TOK_EVERY = TOK_SOME + 1;

    // in
    static final int TOK_IN = TOK_EVERY + 1;

    // satisfies
    static final int TOK_SATISFIES = TOK_IN + 1;

    // for
    static final int TOK_FOR = TOK_SATISFIES + 1;

    // return
    static final int TOK_RETURN = TOK_FOR + 1;

    // "<<"
    static final int TOK_PRECEDES = TOK_RETURN + 1;

    // "<<"
    static final int TOK_FOLLOWS = TOK_PRECEDES + 1;

    // "is"
    static final int TOK_IS = TOK_FOLLOWS + 1;

    // "to"
    static final int TOK_TO = TOK_IS + 1;

    // "intersect"
    static final int TOK_INTERSECT = TOK_TO + 1;

    // "union"
    static final int TOK_UNION = TOK_INTERSECT + 1;

    // "except"
    static final int TOK_EXCEPT = TOK_UNION + 1;

    // "instance"
    static final int TOK_INSTANCE = TOK_EXCEPT + 1;

    // "of"
    static final int TOK_OF = TOK_INSTANCE + 1;

    // "cast"
    static final int TOK_CAST = TOK_OF + 1;

    // "as"
    static final int TOK_AS = TOK_CAST + 1;

    // "qname?"
    static final int TOK_SINGLE_TYPE = TOK_AS + 1;

    // "castable"
    static final int TOK_CASTABLE = TOK_SINGLE_TYPE + 1;

    // "treat"
    static final int TOK_TREAT = TOK_CASTABLE + 1;



    int currentToken = TOK_EOF;
    String _currentTokenValue = null;

    private int currentTokenStartIndex = 0;
    private final String _expr;
    private int _exprIndex = 0;
    private int _exprLength;
    private boolean _recognizeOperator = false;
    
    /**
     * construct with the string to be tokenized
     */
    Expr2Tokenizer(String s) 
    {
        this._expr = s;
        this._exprLength = s.length();
    }

    /**
     * lexes the next token, leaving the token type in
     * <code>currentToken</code>, and the value (if applicable) in
     * <code>tokenValue</code>
     *
     */
    void next() throws ParseException 
    {
        _currentTokenValue = null;
        currentTokenStartIndex = _exprIndex;

        // a mode switch
        boolean currentMaybeOperator = _recognizeOperator;
        _recognizeOperator = true;   // next time in, unless we decide otherwise, below, we'll allow scan for operators

        for (;;) {
            if (_exprIndex >= _exprLength) {
                currentToken = TOK_EOF;
                return;
            }
            char c = _expr.charAt(_exprIndex++);

            switch (c) {
            case ' ':
            case '\t':
            case '\r':
            case '\n':
                currentTokenStartIndex = _exprIndex;
                break;

            case '<':
                _recognizeOperator = false;
                if (_exprIndex < _exprLength && _expr.charAt(_exprIndex) == '=') {
                    _exprIndex++;
                    currentToken = TOK_LTE;
                }
                else
                    currentToken = TOK_LT;
                return;

            case '>':
                _recognizeOperator = false;
                if (_exprIndex < _exprLength && _expr.charAt(_exprIndex) == '=') {
                    _exprIndex++;
                    currentToken = TOK_GTE;
                }
                else
                    currentToken = TOK_GT;
                return;

            case '/':
                _recognizeOperator = false;
                if (_exprIndex < _exprLength && _expr.charAt(_exprIndex) == '/') {
                    _exprIndex++;
                    currentToken = TOK_SLASH_SLASH;
                } else {
                    currentToken = TOK_SLASH;
                }
                return;

            case '=':
                _recognizeOperator = false;
                currentToken = TOK_EQUALS;
                return;

            case '!':
                if (_exprIndex < _exprLength && _expr.charAt(_exprIndex) == '=') {
                    _exprIndex++;
                    currentToken = TOK_NOT_EQUALS;
                    _recognizeOperator = false;
                    return;
                }
                throw new ParseException("illegal character");

            case ',':
                _recognizeOperator = false;
                currentToken = TOK_COMMA;
                return;

            case '|':
                _recognizeOperator = false;
                currentToken = TOK_VBAR;
                return;

            case '+':
                _recognizeOperator = false;
                currentToken = TOK_PLUS;
                return;

            case '-':
                _recognizeOperator = false;
                currentToken = TOK_MINUS;
                return;

            case '(':
                currentToken = TOK_LPAR;
                _recognizeOperator = false;
                return;

            case ')':
                currentToken = TOK_RPAR;
                return;

            case '[':
                currentToken = TOK_LSQB;
                _recognizeOperator = false;
                return;

            case ']':
                currentToken = TOK_RSQB;
                return;

            case '"':
            case '\'':
                _exprIndex = _expr.indexOf(c, _exprIndex);
                if (_exprIndex < 0) {
                    _exprIndex = currentTokenStartIndex + 1;
                    throw new ParseException("missing quote");
                }
                _currentTokenValue = _expr.substring(currentTokenStartIndex + 1,
                                                   _exprIndex++);
                currentToken = TOK_LITERAL;
                return;

            case '$':
                scanName();
                if (_exprIndex == currentTokenStartIndex + 1)
                    throw new ParseException("illegal character");
                if (_exprIndex < _exprLength && _expr.charAt(_exprIndex) == ':') {
                    _exprIndex++;
                    scanName();
                    if (_expr.charAt(_exprIndex - 1) == ':')
                        throw new ParseException("bad character after :");
                }
                _currentTokenValue = _expr.substring(currentTokenStartIndex + 1,
                                                   _exprIndex);
                currentToken = TOK_VARIABLE_REF;
                return;

            case '*':
                if (currentMaybeOperator) {
                    _recognizeOperator = false;
                    currentToken = TOK_MULTIPLY;
                }
                else
                    currentToken = TOK_STAR;
                return;

            case '@':
                currentToken = TOK_AT;
                _recognizeOperator = false;	  
                return;

            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                scanDigits();
                if (_exprIndex < _exprLength
                    && _expr.charAt(_exprIndex) == '.') {
                    _exprIndex++;
                    if (_exprIndex < _exprLength
                        && isDigit(_expr.charAt(_exprIndex))) {
                        _exprIndex++;
                        scanDigits();
                    }
                }
                _currentTokenValue = _expr.substring(currentTokenStartIndex,
                                                   _exprIndex);
                currentToken = TOK_NUMBER;
                return;

            case '.':
                if (_exprIndex < _exprLength && 
                    isDigit(_expr.charAt(_exprIndex))) {

                    ++_exprIndex;
                    scanDigits();
                    _currentTokenValue = _expr.substring(currentTokenStartIndex,
                                                       _exprIndex);
                    currentToken = TOK_NUMBER;
                    return;
                }
                if (_exprIndex < _exprLength && _expr.charAt(_exprIndex) == '.') {
                    _exprIndex++;
                    currentToken = TOK_DOT_DOT;
                } else {
                    currentToken = TOK_DOT;
                }
                _recognizeOperator = false;	  
                return;

            default:
                --_exprIndex;
                scanName();
                if (_exprIndex == currentTokenStartIndex) {
                    throw new ParseException("illegal character");
                }
                if (isAxis()) {
                    _recognizeOperator = false;
                    currentToken = TOK_AXIS;
                    return;
                }
                if (_exprIndex < _exprLength && _expr.charAt(_exprIndex) == ':') {
                    _exprIndex++;
                    if (_exprIndex < _exprLength && 
                        _expr.charAt(_exprIndex) == '*') {

                        _currentTokenValue = 
                            _expr.substring(currentTokenStartIndex,
                                           _exprIndex++ - 1);
                        currentToken = TOK_NAME_COLON_STAR;
                        return;
                    }

                    scanName();
                    if (_expr.charAt(_exprIndex - 1) == ':') {
                        throw new ParseException("bad character after :");
                    }
                    _currentTokenValue = _expr.substring(currentTokenStartIndex,
                                                       _exprIndex);
                    if (followingParen()) {
                        _recognizeOperator = false;
                        currentToken = TOK_CNAME_LPAR;
                    }
                    else {
                        currentToken = TOK_QNAME;
                    }
                    return;
                }
                _currentTokenValue = _expr.substring(currentTokenStartIndex,
                                                   _exprIndex);
                if (currentMaybeOperator) {
                    if (_currentTokenValue.equals("and")) {
                        currentToken = TOK_AND;
                    } else if (_currentTokenValue.equals("or")) {
                        currentToken = TOK_OR;
                    } else if (_currentTokenValue.equals("mod")) {
                        currentToken = TOK_MOD;
                    } else if (_currentTokenValue.equals("then")) {
                        currentToken = TOK_THEN;
                    } else if (_currentTokenValue.equals("else")) {
                        currentToken = TOK_ELSE;
                    } else if (_currentTokenValue.equals("div")) {
                        currentToken = TOK_DIV;
                    } else if (_currentTokenValue.equals("idiv")) {
                        currentToken = TOK_IDIV;
                    } else {
                        throw new ParseException("unrecognized operator name");
                    }
                    _recognizeOperator = false;
                    return;
                }
                if (followingParen()) {
                    if (_currentTokenValue.equals("processing-instruction")) {
                        currentToken = TOK_PROCESSING_INSTRUCTION_LPAR;
                    } else if (_currentTokenValue.equals("comment")) {
                        currentToken = TOK_COMMENT_LPAR;
                    } else if (_currentTokenValue.equals("node")) {
                        currentToken = TOK_NODE_LPAR;
                    } else if (_currentTokenValue.equals("text")) {
                        currentToken = TOK_TEXT_LPAR;
                    } else if (_currentTokenValue.equals("if")) {
                        currentToken = TOK_IF_LPAR;
                    } else {
                        currentToken = TOK_FUNCTION_LPAR;
                    }
                    _recognizeOperator = false;
                }
                else
                    currentToken = TOK_QNAME;
                return;
            }
        }
    }

    private void scanName() 
    {
        if (_exprIndex < _exprLength
            && isNameStartChar(_expr.charAt(_exprIndex)))
            while (++_exprIndex < _exprLength
                   && isNameChar(_expr.charAt(_exprIndex)))
                ;
    }

    private void scanDigits() 
    {
        while (_exprIndex < _exprLength && isDigit(_expr.charAt(_exprIndex))) {
            _exprIndex++;
        }
    }

    // scan ahead, skipping ignoreable whitespace (and comments), looking for a leftt paren
    // if it finds one, moves _exprIndex into position following the paren
    private boolean followingParen() 
    {
        for (int i = _exprIndex; i < _exprLength; i++) {
            switch (_expr.charAt(i)) {
            case '(':
                _exprIndex = i + 1;
                return true;
            case ' ':
            case '\r':
            case '\n':
            case '\t':
                break;
            default:
                return false;
            }
        }
        return false;
    }

    private boolean isAxis() 
    {
        for (int i = _exprIndex; i < _exprLength; i++) {
            switch (_expr.charAt(i)) {
            case ':':
                if (i + 1 < _exprLength && _expr.charAt(i + 1) == ':') {
                    _currentTokenValue = _expr.substring(currentTokenStartIndex,
                                                         _exprIndex);
                    _exprIndex = i + 2;
                    return true;
                }
                break;
            case ' ':
            case '\r':
            case '\n':
            case '\t':
                break;
            default:
                return false;
            }
        }
        return false;
    }

    static private final String nameStartChars =
        "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static private final String nameChars = ".-0123456789";
    static private final String digits = "0123456789";

    private static final boolean isDigit(char c) 
    {
        return digits.indexOf(c) >= 0;
    }

    private static final boolean isSpace(char c) 
    {
        switch(c) {
        case ' ':
        case '\r':
        case '\n':
        case '\t':
            return true;
        }
        return false;
    }

    private static final boolean isNameStartChar(char c) 
    {
        return nameStartChars.indexOf(c) >= 0 || c >= 0x80;
    }
    
    private static final boolean isNameChar(char c) 
    {
        return nameStartChars.indexOf(c) >= 0 || 
            nameChars.indexOf(c) >= 0 || c >= 0x80;
    }

}
