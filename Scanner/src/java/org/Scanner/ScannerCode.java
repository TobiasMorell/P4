package org.Scanner;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.List;

public class ScannerCode {

    private char currentChar;
    private byte currentType;
    private List<Character> WhiteList = new ArrayList<Character> ();

    private StringBuffer currentWord;
    
    public Token GetToken ()
    {
        String currentWord;  
        Token.type tokenType;

        return new Token(tokenType, currentWord);
    }

    private void ScanForTokens ()
    {

    }
}
