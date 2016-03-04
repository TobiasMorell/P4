package org.Scanner;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.List;

public class ScannerCode 
{    
    private List<Character> WhiteList = new ArrayList<Character> ();
   
    public Token GetToken ()
    {
        StringBuffer currentWord = new StringBuffer();  
        char currentChar = 'a';        

        return new Token(Token.type.ASSIGN, currentWord.toString());
    }

    private void ScanForTokens ()
    {

    }

    private boolean isDigit(char c)
    {
        return '0' <= c && c <= '9';
    }

    private boolean isLetter(char c) {
        return 'a' <= c && c <= 'z';
    }


    private boolean isAGraphicCharacter(char c)
    {
        if(isLetter(c) || isDigit(c) || c == ' ') return true;
        else return false;
    }
}
