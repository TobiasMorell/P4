import java_cup.runtime.*;

%%

%public
%class Scanner
%implements sym

%unicode

%line
%column

%eofval{
  return symbol(EOF);
%eofval}

%cup
%cupdebug

%{
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  /** 
   * assumes correct representation of a long value for 
   * specified radix in scanner buffer from <code>start</code> 
   * to <code>end</code> 
   */
  private long parseLong(int start, int end, int radix) {
    long result = 0;
    long digit;

    for (int i = start; i < end; i++) {
      digit  = Character.digit(yycharat(i),radix);
      result*= radix;
      result+= digit;
    }

    return result;
  }
%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/*Comments*/
Comment = {TraditionalComment}|{EndOfLineComment}|{DocumentationComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"

numLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+

/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHARLITERAL

coordLiteral = (numLiteral, numLiteral, numLiteral)
Identifier = [:jletter:][:jletterdigit:]*

%%
<YYINITIAL> {

  /* keywords */
    "IF"        { return symbol(IF); }
    "END"       { return symbol(END); }
    "ELSE"      { return symbol(ELSE); }
    "LOAD"      { return symbol(LOAD); }
    "HEAR"      { return symbol(HEAR); }
    "SIGNAL"    { return symbol(SIGNAL); }
    "BREAK"     { return symbol(BREAK); }
    "RETURN"    { return symbol(RETURN); }
    "REPEAT"    { return symbol(REPEAT); }
    "FOREVER"   { return symbol(FOREVER); }
    "UNTIL"     { return symbol(UNTIL); }
    "AND"       { return symbol(AND); }
    "OR"        { return symbol(OR); }
    "IS"        { return symbol(IS); }
    "NOT"       { return symbol(NOT); }
    "LESS_THAN" { return symbol(LT); }
    "GREATER_THAN" { return symbol(GT); }
    "LESS_THAN_OR_EQUAL_TO" { return symbol(LTE); }
    "GREATER_THAN_OR_EQUAL_TO" { return symbol(GTE); }

 /* Literals */
 "TRUE"         { return symbol(TRUE); }
 "FALSE"        { return symbol(FALSE); }
 {coordLiteral}     { return symbol(CoordLit); }
 "VOID"         { return symbol(VOID); }

 /* types and ID's */
 "NUM"          { return symbol(NUM); }
 "BOOL"         { return symbol(BOOL); }
 "STRING"       { return symbol(STRING); }
 "COORD"        { return symbol(COORD); }
 "LIST"         { return symbol(LIST); }

 /* seperators */
   "("          { return symbol(LPAREN); }
   ")"          { return symbol(RPAREN); }
   ":"          { return symbol(COLON); }
   "."          { return symbol(DOT); }
   ","          { return symbol(COMMA); }

 /* operators */
   "XOR"                { return symbol(XOR); }
   "="                  { return symbol(ASSIGN); }
   "\n"     			{ return symbol(EOL);}
   "+"                  { return symbol(PLUS);}
   "-"                  { return symbol(MINUS);}
   "*"                  { return symbol(MULT);}
   "/"                  { return symbol(DIV);}

  /* Identifier */
    {Identifier}                { return symbol(Identifier, yytext()); }

  /* string literal */
    \"                             { yybegin(STRING); string.setLength(0); }

  /* character literal */
    \'                             { yybegin(CHARLITERAL); }

  /* numeric literals */
    {numLiteral}            			 { return symbol(NumLit, new Double(yytext())); }

 /* comments */
    {Comment}                      { /* ignore */ }

  /* whitespace */
    {WhiteSpace}                   { /*Ignore*/ }
}

<STRING> {
    \"                             { yybegin(YYINITIAL); return symbol(StringLit, string.toString()); }
    {StringCharacter}+             { string.append( yytext() ); }
    }

/* error fallback */
[~]                              { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }

//<<EOF>>                          { return symbol(EOF); }
