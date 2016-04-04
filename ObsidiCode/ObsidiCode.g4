grammar ObsidiCode;

//Fragment rules for lexer
fragment NameStartChar
        :       'A'..'Z' | 'a'..'z';
fragment NameChar
        :       NameStartChar
        |       '0'..'9'
        |       '_'
        ;
fragment Num
        :       '0'..'9';

//Regex for the scanner:
Identifier
	:	NameStartChar NameChar*;

NumLit
	:	Num+ ('.'Num+)?;
CoordLit
	:	'('Num+',' Num+','Num+')';
StringLit
	:	'"'~('"')*'"';

WS
	:	[\t\r' ']+ -> skip;

//Comments
COMMENT
	:	'/*' .*? '*/' -> skip
	;
EOLCOMMENT
	:	'//' .*? '\n' -> skip
	; 
	
TYPE_KEY_NUM: 'NUM';
TYPE_KEY_STRING: 'STRING';
TYPE_KEY_COORD: 'COORD';
TYPE_KEY_BOOL: 'BOOL';
TYPE_KEY_VOID: 'VOID';

prog
	:	roboDcl loads roboBodyDcl;
//Types and literals:
literal
	:	NumLit 
	|	'TRUE'
	|	'FALSE'
	|	CoordLit
	|	StringLit
	;
typeName
	:	Identifier
	|	typeName '.' Identifier
	;

type
	:	type_key=('NUM' | 'BOOL'|'STRING'|'COORD'|'LIST')
	;

loads
	:	loads 'LOAD' '(' StringLit ')' '\n' 
	|	//lambda
	;

//Declarations
roboDcl
	:	Identifier':''\n'
	;
roboBodyDcl
	:	roboBodyDcl memberDcl
	|	memberDcl	
	;

memberDcl
	:	fieldDcl
	|	methodDcl
	|	'\n'
	;

fieldDcl
	:	type variableDclList '\n';
variableDclList
	:	variableDcl
	|	variableDclList ',' variableDcl
	;
variableDcl
	:	variableInitializer
	|	Identifier '=' listInitializer
	;
variableInitializer
	:	assignmentExpression
	;
listInitializer
	:	litList 'END' Identifier
	|	//lambda
	;
litList
	:	litList ',' primary
	|	primary
	;

//method stuff
methodDcl
	:	methodHeader methodBody
	|	hearDcl
	;
methodHeader
	:	('VOID'|t=type) methodDeclarator
	;
methodDeclarator
	:	Identifier '(' formalParams ')' '\n'
	;
methodBody
	:	block 'END' Identifier
	;
hearDcl
	:	'HEAR' Identifier '(' formalParams ')' '\n' block 'END HEAR'
	;

//Statements
block
	:	blockStmtList
	|	//lambda
	;
blockStmtList
	:	blockStmtList statement '\n'
	|	statement '\n'
	;
statement
	:	type variableDclList
	|	stmtNoSub
	|	ifStmt
	|	loopStmt
	;
stmtNoSub
	:	//lambda
	|	signalStmt
	|	exprStmt
	|	'BREAK'
	|	'RETURN' expression
	;
signalStmt
	:	'SIGNAL' Identifier '(' argsList ')'
	;
exprStmt
	:	assignmentExpression
	|	methodInvocation
	;

methodInvocation
	:	typeName '(' formalArgs ')'
	;

ifStmt
	:	'IF' '(' expression ')' '\n' block 'END IF' elseIfOpt elseOpt
	;
elseIfOpt
	:	elseIfOpt '\n' 'ELSE IF' '(' expression ')' '\n' block 'END ELSEIF'
	|	//lambda
	;
elseOpt
	:	'\n' 'ELSE' '\n' block 'END ELSE'
	|	//lambda
	;

loopStmt
	:	repeatStmt
	|	foreverStmt
	;
repeatStmt
	:	'REPEAT UNTIL' '(' expression ')' '\n' block 'END REPEAT'
	;
foreverStmt
	:	'FOREVER' '\n' block 'END FOREVER'
	;

//Args and params
formalArgs
	:	argsList
	|	//lambda
	;
argsList
	:	argsList ',' expression
	|	expression
	;
formalParams
	:	paramsList
	|	//lambda
	;
paramsList
	:	paramsList ',' param
	|	param
	;
param
	:	t=type id=Identifier
	;

//Expression part
expression
	:	assignmentExpression;

assignmentExpression
	:	conditionalExpression
	|	assignment;
assignment
	:	leftHandSide '=' expression;
leftHandSide
	:	typeName listOpt;
listOpt
	:	'[' expression ']'
	|	//lambda
	;

conditionalExpression
	:	conditionOrExpression;
conditionOrExpression
	:	conditionAndExpression
	|	conditionOrExpression 'OR' conditionAndExpression;
conditionAndExpression
	:	xOrExpression
	|	conditionAndExpression 'AND' xOrExpression;
xOrExpression
	:	equalityExpression
	|	xOrExpression 'XOR' equalityExpression;
equalityExpression
	:	relationalExpression
	|	equalityExpression equalityExpressionEnd;
equalityExpressionEnd
	:	'IS' relationalExpression
	|	'NOT' relationalExpression;
relationalExpression
	:	additiveExpression
	|	relationalExpression relationalExpressionEnd;
relationalExpressionEnd
	:	'LESS_THAN' additiveExpression
	|	'GREATER_THAN' additiveExpression
	|	'LESS_THAN_EQUAL' additiveExpression
	|	'GREATER_THAN_EQUAL' additiveExpression;
additiveExpression
	:	multiExpr
	|	additiveExpression additiveExpressionEnd;
additiveExpressionEnd
	:	'+' multiExpr
	|	'-' multiExpr;
multiExpr
	:	unaryExpr
	|	multiExpr multiExprEnd;
multiExprEnd
	:	'*' unaryExpr
	|	'/' unaryExpr;
unaryExpr
	:	'+' unaryExpr
	|	'-' unaryExpr
	|	primary;
primary
	:	literal
	|	'(' expression ')'
	|	typeName listOpt
	|	methodInvocation
;