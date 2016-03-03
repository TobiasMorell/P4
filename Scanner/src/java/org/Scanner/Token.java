package org.Scanner;

import java.util.regex.Pattern;


public class Token {

    public enum type {
        EOF, BREAK, EOL, ROBOT_NAME, LOAD, NUM_DCL, ID,
        STRING_DCL, BOOL_DCL, COORD_DCL, REF_DCL, VOID, END, HEAR,
        SIGNAL, START, IF, REPEAT, UNTIL, FOREVER, ELSE, VAL,
        PLUS, MINUS, TIMES, DIVIDE, ASSIGN, POWER, SQUARE_ROOT,
        BOOL_AND, BOOL_OR, BOOL_EQ, BOOL_GT, BOOL_LT, BOOL_GTE,
        BOOL_LTE, BOOL_LIT, COORD_LIT, STRING_LIT, TYPE, CHEST_LIT,
        BLOCK_LIT, ITEM_LIT, NPC_LIT, RETURN
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
        TokenPattern(type t, Pattern p){

        }
        type Tokentype;
        Pattern pattern;
    }

}
