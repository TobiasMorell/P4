package org.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class ScannerCode 
{    
    private List<Character> WhiteList = new ArrayList<Character> ();
    String _filePath;
    FileReader inputStream;

    public ScannerCode (String filePath)
    {
        _filePath = filePath;

        try {
            inputStream = new FileReader(_filePath);
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            inputStream.close();
        }
    }
    public Token GetToken ()
    {
        StringBuffer currentWord = new StringBuffer();  
        char currentChar = 'a';        
    }

    private void ScanForTokens (FileReader reader)
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
