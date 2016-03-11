import java_cup.runtime.*;

%%

%public
%class Scanner
%implements sym

%unicode

%line
%column

%cup
%cupdebug

%{
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new JavaSymbol(type, yyline+1, yycolumn+1);
  

  private Symbol symbol(int type, Object value) {
    return new JavaSymbol(type, yyline+1, yycolumn+1, value);
  

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

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | 
          {DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"

/* identifiers */
Identifier = [:jletter:][:jletterdigit:]*

/* floating point literals */        
numLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+

/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHARLITERAL

Identifier = [:jletter:][:jletterdigit:]*

%%
<YYINITIAL> {

  /* keywords */
    "START"     { return symbol(START); } 
    "IF"        { return symbol(IF); }                
    "NUM"       { return symbol(NUM); } 
    "END"       { return symbol(END); }
    "VOID"      { return symbol(VOID); }
    "LOAD"      { return symbol(LOAD); }
    "HEAR"      { return symbol(HEAR); }
    "REPEAT"    { return symbol(REPEAT); }
    "UNTIL"     { return symbol(UNTIL); }
    "FOREVER"   { return symbol(FOREVER); }
    "ELSE"      { return symbol(ELSE); }    
    "STRING"    { return symbol(STRING); }
    "BOOL"      { return symbol(BOOL); }
    "COORD"     { return symbol(COORD); }      
    "SQRT"      { return symbol(SQRT);  }
 
 /* boolean literals */
    "TRUE" { return symbol(TRUE); }    
    "FALSE" { return symbol(FALSE); }    
 
 /* seperators */
   "("          { return symbol(lparen); }     
   ")"          { return symbol(rparen); } 
   ","          { return symbol(comma); } 
   "."          { return symbol(dot); }
   ":"          { return symbol(COLON); }

 /* operators */
   "="                          { return symbol(ASSIGN); } 
   "GREATER_THAN"               { return symbol(GT); } 
   "IS"                         { return symbol(IS); } 
   "NOT"                        { return symbol(NOT); } 
   "LESS_THAN"                  { return symbol(LT); } 
   "LESS_THAN_OR_EQUAL_TO"      { return symbol(LTE); }
   "GREATER_THAN_OR_EQUAL_TO"   { return symbol(GTE); }
   "AND"                        { return symbol(AND); }
   "OR"                         { return symbol(OR); }
   "+"                          { return symbol(plus); }
   "-"                          { return symbol(minus); }
   "*"                          { return symbol(asterix);}
   "/"                          { return symbol(slash); }
   "^" 			        { return symbol(hat);} 
   "\n"     			{ return symbol(EOL);} 
   ""                           { return symbol(lambda); } 
 /* Identifier */
    {Identifier}                { return symbol(IDENTIFIER, yytext()); }

  /* string literal */
  \"                             { yybegin(STRING); string.setLength(0); }

  /* character literal */
  \'                             { yybegin(CHARLITERAL); }

  /* numeric literals */
  
  {numLiteral}            			 { return symbol(num_lit, new Integer(yytext())); }

  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

}

<STRING> {
  \"                             { yybegin(YYINITIAL); return symbol(STRING_LITERAL, string.toString()); }
  
  {StringCharacter}+             { string.append( yytext() ); }
}  

<CHARLITERAL> {
  {SingleCharacter}\'            { yybegin(YYINITIAL); return symbol(CHARACTER_LITERAL, yytext().charAt(0)); }
  }

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return symbol(EOF); }
