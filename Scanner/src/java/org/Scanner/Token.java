package org.Scanner;

import com.sun.javafx.fxml.expression.Expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Token {

    public enum type {
        EOF, BREAK, EOL, ROBOT_NAME, LOAD, NUM_DCL, ID,
        STRING_DCL, BOOL_DCL, COORD_DCL, REF_DCL, VOID, END, HEAR,
        SIGNAL, START, IF, REPEAT, UNTIL, FOREVER, ELSE, VAL,
        PLUS, MINUS, TIMES, DIVIDE, ASSIGN, POWER, SQUARE_ROOT,
        BOOL_AND, BOOL_OR, BOOL_EQ, BOOL_GT, BOOL_LT, BOOL_GTE,
        BOOL_LTE, BOOL_LIT, COORD_LIT, STRING_LIT
    }

    public final type _type;
    public final String value;

    /**
     * @param t   The type of the Token
     * @param val The string value of the Token
     */
    public Token(type t, String val) {
        _type = t;
        value = val;
    }

    public Token(type t) {
        this(t, "");
    }

    public static class TokenPattern {
        TokenPattern(type t, String p){
            tokenType = t;
            regex = p;
        }
        public final type tokenType;
        public final String regex;
    }

    public static final ArrayList<TokenPattern> patternList = new ArrayList<TokenPattern>(Arrays.asList(
            new TokenPattern(type.ASSIGN,"="),
            new TokenPattern(type.BOOL_AND,"AND"),
            new TokenPattern(type.BOOL_DCL,"BOOL"),
            new TokenPattern(type.BOOL_EQ,"IS"),
            new TokenPattern(type.BOOL_GT,"GREATER_THAN"),
            new TokenPattern(type.BOOL_GTE,"GREATER_THAN_EQUAL"),
            new TokenPattern(type.BOOL_LIT,"TRUE|FALSE")
    ));

}
