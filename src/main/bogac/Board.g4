/*
    @Author Jakob Saadbye, Hans Heje, Ming Hui
*/

grammar Board;

//Block structures
SETUPBLC  : 'SETUP';
RULESBLC  : 'RULES';
GMLOOPBLC : 'GMLOOP';

//Primitive type declarations
INTDCL      : 'int';
BOOLDCL     : 'bool';
STRDCL      : 'str';
LISTDCL     : 'list';


//Design declerations
DESIGNDCL   : 'design';

//Special decleration
ACTIONDCL   : 'action';
CHOICEDCL   : 'choice';

//Primitive types
INT     : ('-')?[0-9]+;
BOOL    : 'True' | 'False';
STRING  : '"' ('\\' ["\\] | ~["\\\r\n])* '"';


//Operators
MOD     : '%';
PLUS    : '+';
MINUS   : '-';
MULT    : '*';
DIV     : '/';
EXP     : '^';

ASSIGN  : '=';
GTH     : '>';
LTH     : '<';
GTHEQL  : '>=';
LTHEQL  : '<=';
EQL     : '==';
NEQL    : '!=';
NOT     : 'not'|'!';
AND     : 'and'|'&&';
OR      : 'or'|'||';

//Control structures
IF      : 'if';
ELSEIF  : 'elseif';
ELSE    : 'else';
FOR     : 'for';
FOREACH : 'foreach';
RETURN  : 'return';
WHILE   : 'while';

//Special keywords
FROM        : 'from';
TILE_EVENT  : 'onLand' | 'onLeave' | 'onVisit';
IN          : 'in';
SPECIAL     : 'special';
UNI_DIR     : 'uni';
BI_DIR      : 'bi';
STATIC_DIR  : 'static';

PRINT   : 'print';

//Delimiters
LPAREN      : '(';
RPAREN      : ')';
LSBRACE     : '[';
RSBRACE     : ']';
LBRACE      : '{';
RBRACE      : '}';
COMMA       : ',';
COLON       : ':';

IDENTIFIER  : [a-zA-Z][a-zA-Z0-9]*('_'+[a-zA-Z0-9]+)*;
NEWLINE : '\n'      -> skip;
WS      : [ \t\r\n] -> skip;    //Tells antler to skip over these characters
EOL     : ';';
DOT     : '.';

game
    : setup rules gameloop
    ;

setup
    : SETUPBLC setupBlock
    ;

rules
    : RULESBLC rulesBlock
    ;

gameloop
    : EOF
    | print
    ;

setupBlock
    : LBRACE (normalDeclaration | designDeclaration | statements | setupBlock | assignmentStatement)* RBRACE
    ;

normalBlock
    : LBRACE (normalDeclaration | statements | normalBlock | assignmentStatement)* RBRACE
    ;

//Primitive type decleration
normalDeclaration
    : integerDeclaration EOL
    | booleanDeclaration EOL
    | stringDeclaration EOL
    | listDeclaration EOL
    | IDENTIFIER (IDENTIFIER|COMMA)* EOL
    ;

rulesBlock
    : LBRACE (uniqueDeclaration | statements | rulesBlock | assignmentStatement)* RBRACE
    ;

uniqueDeclaration
    : specialDeclaration
    | actionDeclaration
    | choiceDeclaration
    ;

//Design declerations should only appear in SETUP block
designDeclaration
    : DESIGNDCL IDENTIFIER (FROM IDENTIFIER)? designBody
    ;

integerDeclaration
    : INTDCL IDENTIFIER ASSIGN arithmeticExpression COMMA integerDeclaration
    | INTDCL IDENTIFIER ASSIGN arithmeticExpression
    | INTDCL IDENTIFIER
    ;

booleanDeclaration
    : BOOLDCL IDENTIFIER ASSIGN booleanExpression COMMA booleanDeclaration
    | BOOLDCL IDENTIFIER ASSIGN booleanExpression
    ;

stringDeclaration
    : STRDCL IDENTIFIER ASSIGN STRING COMMA stringDeclaration
    | STRDCL IDENTIFIER ASSIGN STRING
    ;

listDeclaration
    : LISTDCL COLON IDENTIFIER ASSIGN LSBRACE (IDENTIFIER|COMMA)* RSBRACE
    | LISTDCL COLON IDENTIFIER IDENTIFIER LSBRACE INT RSBRACE
    ;


//Special and choice declarations should only be found in Rules block NOT IMPLEMENTED
specialDeclaration
    : SPECIAL IDENTIFIER TILE_EVENT LPAREN IDENTIFIER COMMA IDENTIFIER RPAREN rulesBlock
    ;

choiceDeclaration
    : CHOICEDCL IDENTIFIER LPAREN IDENTIFIER IDENTIFIER RPAREN (COLON primitiveType)? rulesBlock //Should have a special choice block
    ;

actionDeclaration
    : ACTIONDCL IDENTIFIER LPAREN (formalParameters)? RPAREN (COLON primitiveType)? rulesBlock
    ;

assignmentStatement
    : intAssigment EOL
    | booleanAssigment EOL
    | stringAssigment EOL
    | dotAssignment EOL
    | actionAssignment EOL
    | choiceAssignment
    ;

intAssigment
    : IDENTIFIER ASSIGN arithmeticExpression*
    ;

booleanAssigment
    : IDENTIFIER ASSIGN booleanExpression
    ;

stringAssigment
    : IDENTIFIER ASSIGN STRING
    ;

dotAssignment
    : IDENTIFIER DOT IDENTIFIER ASSIGN (STRING|INT|BOOL|IDENTIFIER)*
    ;

choiceAssignment
    : (INT COLON)* LBRACE IDENTIFIER LPAREN (INT)* RPAREN RBRACE COMMA
    | IDENTIFIER LPAREN (IDENTIFIER | COMMA)* RPAREN
    | IDENTIFIER COLON LBRACE print RBRACE EOL
    ;

actionAssignment
    : IDENTIFIER DOT IDENTIFIER LPAREN IDENTIFIER RPAREN
    | IDENTIFIER LPAREN (IDENTIFIER | COMMA)* RPAREN
    ;


// Special body's
designBody
    : LBRACE (fieldRow)* RBRACE
    ;

fieldRow
    : primitiveType IDENTIFIER EOL
    | primitiveType IDENTIFIER LPAREN IDENTIFIER IDENTIFIER RPAREN EOL
    ;

//Primitive types
primitiveType
    : INTDCL | BOOLDCL | STRDCL
    ;

/*fieldType
    : INTDCL
    | BOOLDCL
    | STRDCL
    //| IDENTIFIER    //This identifier needs to be declared before it can be used here
    ;*/

formalParameters
    : primitiveType COLON IDENTIFIER
    | primitiveType COLON IDENTIFIER COMMA formalParameters
    ;

statements
    : ifstmnt
    | whilestmnt
    | foreach
    ;

arithmeticExpression
    : additive+
    ;
booleanExpression
    : logor+
    ;

additive
    : additive PLUS multiplicative
    | additive MINUS multiplicative
    | multiplicative
    ;

multiplicative
    : multiplicative MULT pow
    | multiplicative DIV pow
    | multiplicative MOD pow
    | pow
    ;

pow
    : pow EXP arithmeticAtom
    | arithmeticAtom
    ;

arithmeticAtom
    : INT
    | IDENTIFIER
    | LPAREN arithmeticExpression RPAREN
    ;

logor
    : logor OR logand
    | logand
    ;

logand
    : logand AND equality
    | equality
    ;

equality
    : equality EQL relational
    | equality NEQL relational
    | relational
    ;

relational
    : relational GTH arithmeticExpression
    | relational LTH arithmeticExpression
    | relational GTHEQL arithmeticExpression
    | relational LTHEQL arithmeticExpression
    | arithmeticExpression
    | negation
    ;

negation
    : NOT booleanAtom
    | booleanAtom
    ;

//!True > 5
booleanAtom
    : BOOL
    | IDENTIFIER
    | LPAREN booleanExpression RPAREN
    ;

ifstmnt
    : IF LPAREN booleanExpression RPAREN normalBlock
    | IF LPAREN booleanExpression RPAREN normalBlock elsestmnt
    ;

elsestmnt
    : ELSE normalBlock
    | ELSE ifstmnt
    ;

whilestmnt
    : WHILE LPAREN booleanExpression RPAREN normalBlock
    ;

foreach
    : FOREACH IDENTIFIER IN IDENTIFIER normalBlock
    ;

print
    : PRINT LPAREN (STRING | INT | arithmeticExpression | IDENTIFIER)* RPAREN
    ;