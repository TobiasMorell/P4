grammar ObsidiCode;

//Fragment rules for lexer
fragment NameStartChar
        :       'A'..'Z' | 'a'..'z';
fragment NameChar
        :       NameStartChar
        |       Num
        |       '_'
        ;
fragment Num
        :       '0'..'9';

//Regex for the scanner:
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

NUM: 'NUM';
STRING: 'STRING';
COORD: 'COORD';
BOOL: 'BOOL';
VOID: 'VOID';
LIST: 'LIST';

EQ_MOD_IS: 'IS';
EQ_MOD_NOT: 'NOT';

RELATIONAL_KEY_LT: 'LESS_THAN';
RELATIONAL_KEY_GT: 'GREATER_THAN';
RELATIONAL_KEY_LTE: 'LESS_THAN_EQUAL';
RELATIONAL_KEY_GTE: 'GREATHER_THAN_EQUAL';

OP_PLUS: '+';
OP_MINUS: '-';
OP_MULT: '*';
OP_DIV: '/';

TRUE: 'TRUE';
FALSE: 'FALSE';

Identifier
    :	NameStartChar NameChar*;

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
	:	id=Identifier
	|	parent=typeName '.' id=Identifier
	;

typePrefix
	:	type='NUM'
	|   type='BOOL'
	|   type='STRING'
	|   type='COORD'
	|   type='LIST'
	;

loads
	:	recursion=loads 'LOAD' '(' load_id=StringLit ')' '\n' 
	|	//lambda
	;

//Declarations
roboDcl
	:	id=Identifier':''\n'
	;
roboBodyDcl
	:	recursion=roboBodyDcl dcl=memberDcl
	|	dcl=memberDcl	
	;

memberDcl
	:	dcl=fieldDcl
	|	met_dcl=methodDcl
	|	'\n'
	;

fieldDcl
	:	t=typePrefix dcl_list=variableDclList '\n';
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

//method stuff
methodDcl
	:	header=methodHeader body=methodBody
	|	hearDcl
	;
methodHeader
	:	(t=typePrefix | 'VOID') declarator=methodDeclarator
	;
methodDeclarator
	:	id=Identifier '(' params=formalParams ')' '\n'
	;
methodBody
	:	body=block 'END' ?Identifier
	;
hearDcl
	:	'HEAR' id=Identifier '(' params=formalParams ')' '\n' body=block 'END HEAR'
	;

//Statements
block
	:	list=blockStmtList
	|	//lambda
	;
blockStmtList
	:	list=blockStmtList stmt=statement '\n'
	|	stmt=statement '\n'
	;
statement
	:	t=typePrefix dcl=variableDclList		#stmtDeclaration
	|	skipNoSub=stmtNoSub				#stmtSkip
	|	skipIf=ifStmt					#stmtSkip
	|	skipLoop=loopStmt				#stmtSkip
	;
stmtNoSub
	:	/*lambda*/						#noSubLambda
	|	skipSignal=signalStmt			#noSubSkip
	|	skipExpr=exprStmt					#noSubSkip
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

ifStmt
	:	'IF' '(' expr=expression ')' '\n' body=block 'END IF' elseIfStmt=elseIfOpt elseStmt=elseOpt
	;
elseIfOpt
	:	recursion=elseIfOpt '\n' 'ELSE IF' '(' expr=expression ')' '\n' body=block 'END ELSEIF'	#elseIf
	|	/*lambda*/																				#noElseIf
	;
elseOpt
	:	'\n' 'ELSE' '\n' body=block 'END ELSE'													#else
	|	/*lambda*/																				#noElse
	;

loopStmt
	:	rep=repeatStmt
	|	ever=foreverStmt
	;
repeatStmt
	:	'REPEAT UNTIL' '(' expr=expression ')' '\n' body=block 'END REPEAT'
	;
foreverStmt
	:	'FOREVER' '\n' body=block 'END FOREVER'
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
	:	'[' expr=expression ']'		
	|	/*lambda*/
	;

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
	|	lhs=leftHandSide			#primaryIdRef
	|	methodInvocation		#primaryMethodInvoc
;