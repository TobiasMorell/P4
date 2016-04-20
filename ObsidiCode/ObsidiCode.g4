grammar ObsidiCode;



//Fragment rules for lexer - must be part of another lexical rule
fragment NameStartChar
        :       'A'..'Z' | 'a'..'z';
fragment NameChar
        :       NameStartChar
        |       Num
        |       '_'
        ;
fragment Num
        :       '0'..'9';

//Literals are defined by regular expressions:
NumLit
	:	Num+ ('.'Num+)?;
CoordLit
	:	'('Num+',' Num+','Num+')';
StringLit
	:	'"'~('"')*'"';

//Define comments
COMMENT
	:	'/*' .*? '*/' -> skip
	;
EOLCOMMENT
	:	'//' ~'\n'* -> skip
	;

//Tells ANTLR to skip white-space
WS
	:	[\t' ']+ -> skip;
//Define newline separator (used here as statement end)
NEWLINE
    :   '\r' '\n' | '\n' | '\r';

//Reserved type keywords
NUM: 'NUM';
STRING: 'STRING';
COORD: 'COORD';
BOOL: 'BOOL';
VOID: 'VOID';
LIST: 'LIST';

//Reserved equivalence keywords
EQ_MOD_IS: 'IS';
EQ_MOD_NOT: 'NOT';

//Reserved relational keywords
RELATIONAL_KEY_LT: 'LESS_THAN';
RELATIONAL_KEY_GT: 'GREATER_THAN';
RELATIONAL_KEY_LTE: 'LESS_THAN_EQUAL';
RELATIONAL_KEY_GTE: 'GREATHER_THAN_EQUAL';

//Reserved operators
OP_PLUS: '+';
OP_MINUS: '-';
OP_MULT: '*';
OP_DIV: '/';

//Reserved boolean keywords
TRUE: 'TRUE';
FALSE: 'FALSE';

//Identifier lexical rule
Identifier
    :	NameStartChar NameChar*;

//Start rule and 'imports':
prog
	:	roboDcl loads roboBodyDcl;
loads
    :	recursion=loads 'LOAD' '(' load_id=StringLit ')' NEWLINE   #nonLambdaLoad
    |	/*lambda*/                                                 #lambdaLoad
    |   NEWLINE                                                    #lambdaLoad
    ;
//Types and literals:
literal
	:	NumLit 
	|	'TRUE'
	|	'FALSE'
	|	CoordLit
	|	StringLit
	;
typeName
	:	id=Identifier                                   #typeNameIdentifier
	|	parent=typeName '.' id=Identifier               #typeNameIdentifier
	|   parent=typeName '.' meth=methodInvocation       #typeNameMethodInvoc
	;
typePrefix
	:	type='NUM'
	|   type='BOOL'
	|   type='STRING'
	|   type='COORD'
	|   type='LIST'
	;

//Declarations
roboDcl
	:	id=Identifier':'NEWLINE
	;
roboBodyDcl
	:	recursion=roboBodyDcl dcl=memberDcl
	|	dcl=memberDcl	
	;
memberDcl
	:	dcl=fieldDcl            #memberDeclNotLambda
	|	met_dcl=methodDcl           #memberDeclNotLambda
	|	NEWLINE                 #memberDclLambda
	;
fieldDcl
	:	t=typePrefix dcl_list=variableDclList NEWLINE;
variableDclList
	:	single=variableDcl
	|	list=variableDclList ',' single=variableDcl
	;
variableDcl
	:	var_init=variableInitializer
	|	id=Identifier '=' list_init=listInitializer
	;
variableInitializer 
	:	expr=assignmentExpression
	;
listInitializer
	:	list=litList 'END' Identifier
	|	//lambda
	;
litList
	:	list=litList ',' single=primary
	|	single=primary
	;
methodDcl
	:	header=methodHeader body=methodBody
	|	hearDcl
	;
hearDcl
	:	'HEAR' id=Identifier '(' params=formalParams ')' NEWLINE body=block 'END HEAR'
	;
//Parts of method declarations
methodHeader
	:	(t=typePrefix | 'VOID') declarator=methodDeclarator
	;
methodDeclarator
	:	id=Identifier '(' params=formalParams ')' NEWLINE
	;
methodBody
	:	body=block 'END' ?Identifier
	;

//Statements
block
	:	list=blockStmtList
	|	//lambda
	;
blockStmtList
	:	list=blockStmtList stmt=statement NEWLINE
	|	stmt=statement NEWLINE
	;
statement
	:	t=typePrefix dcl=variableDclList
	|	skipNoSub=stmtNoSub
	|	skipIf=ifStmt
	|	skipLoop=loopStmt
	;
stmtNoSub
	:	/*lambda*/						#noSubLambda
	|	skipSignal=signalStmt			#noSubSkip
	|	skipExpr=exprStmt				#noSubSkip
	|	'BREAK'							#noSubBrk
	|	'RETURN' expr=expression		#noSubRet
	;
signalStmt
	:	'SIGNAL' id=Identifier '(' arguments=argsList ')'
	;
exprStmt
	:	assExpr=assignmentExpression
	|	meth_invoc=methodInvocation
	;

methodInvocation
	:	id=typeName '(' args=formalArgs ')'
	;
//if statements
ifStmt
	:	'IF' '(' expr=expression ')' NEWLINE body=block 'END IF' elseIfStmt=elseIfOpt elseStmt=elseOpt
	;
elseIfOpt
	:	recursion=elseIfOpt NEWLINE 'ELSE IF' '(' expr=expression ')' NEWLINE body=block 'END ELSEIF'	#elseIf
	|	/*lambda*/																				        #noElseIf
	;
elseOpt
	:	NEWLINE 'ELSE' NEWLINE body=block 'END ELSE'													#else
	|	/*lambda*/																				        #noElse
	;
//loop statements
loopStmt
	:	rep=repeatStmt
	|	ever=foreverStmt
	;
repeatStmt
	:	'REPEAT UNTIL' '(' expr=expression ')' NEWLINE body=block 'END REPEAT'
	;
foreverStmt
	:	'FOREVER' NEWLINE body=block 'END FOREVER'
	;

//Args and params
formalArgs
	:	list=argsList
	|	//lambda
	;
argsList
	:	argsList ',' expression
	|	expression
	;
formalParams
	:	list=paramsList
	|	//lambda
	;
paramsList
	:	list=paramsList ',' p=param		
	|	p=param						
	;
param
	:	t=typePrefix id=Identifier
	;

//Expression part
expression
	:	assignmentExpression;

assignmentExpression
	:	skipCond=conditionalExpression
	|	skipAss=assignment
	;
assignment
	:	lhs=leftHandSide '=' expr=expression;
leftHandSide
	:	tn=typeName ext=listOpt;
listOpt
	:	'[' expr=expression ']'		//<--- Only temporary!
	|	/*lambda*/
	;
//Boolean
conditionalExpression
	:	or=conditionOrExpression;
conditionOrExpression
	:	and=conditionAndExpression
	|	or=conditionOrExpression 'OR' and=conditionAndExpression;
conditionAndExpression
	:	xor=xOrExpression
	|	and=conditionAndExpression 'AND' xor=xOrExpression;
xOrExpression
	:	eq=equalityExpression
	|	xor=xOrExpression 'XOR' eq=equalityExpression;
equalityExpression
	:	rel=relationalExpression
	|	eq=equalityExpression eq_end=equalityExpressionEnd;
equalityExpressionEnd
	:	eq_mod='IS' rel=relationalExpression
	|	eq_mod='NOT' rel=relationalExpression
	;
relationalExpression
	:	add=additiveExpression
	|	rel=relationalExpression rel_end=relationalExpressionEnd;
relationalExpressionEnd
	:	relational_key='LESS_THAN' add=additiveExpression
	|	relational_key='GREATER_THAN' add=additiveExpression
	|	relational_key='LESS_THAN_EQUAL' add=additiveExpression
	|	relational_key='GREATER_THAN_EQUAL' add=additiveExpression;
//Arithmetic
additiveExpression
	:	mult=multiExpr
	|	add=additiveExpression add_end=additiveExpressionEnd;
additiveExpressionEnd
	:	op='+' mult=multiExpr
	|	op='-' mult=multiExpr;
multiExpr
	:	un=unaryExpr
	|	mult=multiExpr mult_end=multiExprEnd;
multiExprEnd
	:	op='*' un=unaryExpr
	|	op='/' un=unaryExpr;
unaryExpr
	:   op='-' un=unaryExpr
	|	prim=primary;
primary
	:	literal					#primaryLiteral
	|	'(' expression ')'		#parenExpr
	|	lhs=leftHandSide		#primaryIdRef
	|	methodInvocation		#primaryMethodInvoc
;