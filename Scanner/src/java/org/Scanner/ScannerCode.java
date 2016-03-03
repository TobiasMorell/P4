/**
 * Created by Arne K. Rasmussen on 29-02-2016.
 */
import java.lang.StringBuffer;
import CharStream.java;
import Token.java;
import

public class ScannerCode {

    private char currentChar = //load in first char;
    private byte currentType;

    // Mutable sequence of chars
    private StringBuffer currentWord;

    private void checkThenAddToCurrentWord(char expectedChar) {
        if (currentChar == expectedChar) {
            currentWord.append(currentChar);
            currentChar = //LoadNextChar;
        } else
    }




    private void addToCurrentWord() {
        currentWord.append(currentChar);
        currentChar = ;
    }

    private boolean isDigit(char c)
    {
        return '0' <= c && c <= '9';
    }

    private boolean isLetter(char c){
        return 'a' <= c && c <= 'z';
    }

    private boolean isGraphic(char c)
    {
        if(isLetter(c) || isDigit(c) || c == ' ') return true;
        else return false;
    }


    // scanToken, her gennemgås struktureren finder ud af om identifier eller intlit, og checker for operatorer
    // Med hvad med KEYWORDS? Det tjekkes i Token constructoren og så kan typen ændres der
    private byte scanToken() {
        switch(currentChar)
        case 'a':case 'b': addToCurrentWord();
        while(isLetter((currentChar) || isDigit(currentChar))) addToCurrentWord();
        return new Token(IDENTIFIER);

        case '0':case '1': addToCurrentWord();
        while(isLetter(currentChar) ||  isDigit(currentChar)) addToCurrentWord();
        return new Token(NUM);
        case '(': addToCurrentWord();
        return Token(LEFTPAREN);


    }

    private byte scanSeperator(){
        //Scan whatever seperators the language has
    }

    public Token scan(){
        while (currentChar == ' ' || currentChar == '\n')
            scanSeperator();
        currentWord = new StringBuffer("");
        currentType = scanToken();
        return new Token(currentType, currentWord.toString());
    }






}
