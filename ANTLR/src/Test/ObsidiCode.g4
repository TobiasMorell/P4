grammar ObsidiCode;

//Regex for the scanner:
Identifier
	:	[A-z][0-z]*;
NumLit
	:	[0-9]+([\.][0-9]+)?;
CoordLit
	:	[\(][0-9][,] [0-9][,] [0-9][\)];
StringLit
	:	[^"]+;

//Skip blank-space
WS 
	: [ \t\r\n]+ -> skip; //<--- newline added for tests!

//Start rule:
expression
	:	assignmentExpression;

literal
	:	NumLit
	|	'TRUE'
	|	'FALSE'
	|	CoordLit
	|	'"' StringLit '=';
typeName
	:	Identifier
	|	typeName '.' Identifier
	;

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
	;conditionalExpression
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
	|	typeName listOpt;
