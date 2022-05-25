/*
    @Author Jakob Saadbye, Hans Heje, Ming Hui
*/

grammar Board;

//Block structures
SETUPBLC    : 'SETUP';
RULESBLC    : 'RULES';
GAMELOOPBLC : 'GAMELOOP';

//Primitive type declarations
INTDCL      : 'int';
BOOLDCL     : 'bool';
STRDCL      : 'str';
LISTDCL     : 'list';

//Design declerations
DESIGNDCL   : 'design';

//Special decleration
SPECIALDCL  : 'special';
ACTIONDCL   : 'action';
CHOICEDCL   : 'choice';
PATHDCL     : 'path';
GRIDDCL     : 'grid';

//Primitive types
INT     : [0-9]+;
BOOL    : 'true' | 'false';
STR     : '"' ('\\' ["\\] | ~["\\\r\n])* '"';

//Control structures
IF      : 'if';
ELSEIF  : 'elseif';
ELSE    : 'else';
FOR     : 'for';
FOREACH : 'foreach';
WHILE   : 'while';
RETURN  : 'return';
BREAK   : 'break';
SIZEOF  : 'sizeof';

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

//Special keywords
FROM        : 'from';
TILE_EVENT  : 'onLand' | 'onLeave' | 'onVisit';
IN          : 'in';
UNI_DIR     : 'uni';
BI_DIR      : 'bi';
STATIC_DIR  : 'static';
RANDOM      : 'random';

PRINT       : 'print';
INPUT       : 'input';
EXIT        : 'exit';

//Delimiters
LPAREN      : '(';
RPAREN      : ')';
LSBRACE     : '[';
RSBRACE     : ']';
LBRACE      : '{';
RBRACE      : '}';
QUOTE       : '"';
COLON       : ':';
EOL         : ';';
DOT         : '.';
COMMA       : ',';

IDENTIFIER  : [a-zA-Z][a-zA-Z0-9]*('_'+[a-zA-Z0-9]+)*;
NEWLINE : '\n'      -> skip;
WS      : [ \t\r\n] -> skip;    //Tells antler to skip over these characters

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

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
    : GAMELOOPBLC gameloopBlock
    ;

setupBlock
    : LBRACE (normalDeclaration | setupDeclaration | statement | setupBlock )* RBRACE
    ;

normalBlock
    : LBRACE (normalDeclaration | statement | normalBlock )* RBRACE
    ;

rulesBlock
    : LBRACE (rulesDeclaration | statement | rulesBlock )* RBRACE
    ;

gameloopBlock
    : LBRACE (statement | gameloopBlock)* RBRACE
    ;

//Primitive type decleration
normalDeclaration
    : INTDCL integerDeclaration EOL
    | BOOLDCL booleanDeclaration EOL
    | STRDCL stringDeclaration EOL
    | LISTDCL listDeclaration EOL
    | designDeclaration EOL
    | sequentialDeclaration EOL
    ;

// Setup special Declerations
setupDeclaration
    : pathDeclaration EOL
    | gridDeclaration EOL
    | designDefinition
    ;

rulesDeclaration
    : specialDeclaration
    | actionDefinition
//  | choiceDeclaration
    ;

designBlock
    : LBRACE ((INT | BOOL | STR) | ((INT | BOOL | STR) COMMA))* RBRACE // Nested Design Decl
    | (INT | BOOL | STR | IDENTIFIER)                                               // Normal Prim in Decl
    ;

designDeclaration
    : IDENTIFIER IDENTIFIER
    | IDENTIFIER IDENTIFIER ASSIGN LBRACE designBlock (COMMA designBlock)* RBRACE
    ;

//Design declerations should only appear in SETUP block
designDefinition
    : DESIGNDCL IDENTIFIER (FROM IDENTIFIER)? designBody
    ;

integerDeclaration
    : IDENTIFIER ASSIGN arithmeticExpression
    | IDENTIFIER
    ;

sequentialDeclaration
    : INTDCL integerDeclaration (COMMA integerDeclaration)+
    | BOOLDCL booleanDeclaration (COMMA booleanDeclaration)+
    | STRDCL stringDeclaration (COMMA stringDeclaration)+
    | designDeclaration (COMMA IDENTIFIER)+
    ;

booleanDeclaration
    : IDENTIFIER ASSIGN booleanExpression
    | IDENTIFIER
    ;

stringDeclaration
    : IDENTIFIER ASSIGN STR
    | IDENTIFIER
    ;

listDeclaration
//    : COLON listType IDENTIFIER ASSIGN LSBRACE (listElement? | listElement (COMMA listElement)*)  RSBRACE
    : COLON listType IDENTIFIER ASSIGN list
    | COLON listType IDENTIFIER
    ;

// Allows empty lists []
list
    : LSBRACE (listElement (COMMA listElement)*)? RSBRACE
    ;

listElement
    : primitiveValue
    | list // Allows nested lists -> list:list:int matrix = [[1,2,3], [1,2,3]];
    | IDENTIFIER
    ;

listType
    : IDENTIFIER
    | INTDCL
    | BOOLDCL
    | STRDCL
    | LISTDCL COLON listType //To define lists of lists
    ;

pathDeclaration
    : PATHDCL IDENTIFIER LSBRACE INT RSBRACE (UNI_DIR | BI_DIR | STATIC_DIR)?
    | PATHDCL COLON IDENTIFIER IDENTIFIER LSBRACE INT RSBRACE (UNI_DIR | BI_DIR | STATIC_DIR)?
    ;

gridDeclaration
    : GRIDDCL IDENTIFIER LSBRACE INT COMMA INT RSBRACE
    | GRIDDCL COLON IDENTIFIER IDENTIFIER LSBRACE INT COMMA INT RSBRACE
    ;

//Special and choice declarations should only be found in Rules block
specialDeclaration
    : SPECIALDCL IDENTIFIER TILE_EVENT LPAREN IDENTIFIER COMMA IDENTIFIER RPAREN rulesBlock
    ;

actionDeclaration
    : ACTIONDCL IDENTIFIER LPAREN (formalParameter | formalParameter (COMMA formalParameter)+)? RPAREN (COLON type)?
    ;

actionDefinition
    : ACTIONDCL IDENTIFIER LPAREN (formalParameter | formalParameter (COMMA formalParameter)+)? RPAREN (COLON type)? normalBlock
    ;

returnStatement
    : RETURN expression
    ;

exitStatement
    : EXIT
    ;

randomCall
    : RANDOM LPAREN arithmeticExpression RPAREN
    ;

actionCall
    : IDENTIFIER LPAREN (expression | expression (COMMA expression )+)? RPAREN
    ;

//INTDCL | BOOLDCL | STRDCL
type
    : INTDCL
    | BOOLDCL
    | STRDCL
    | IDENTIFIER //Design ref
    | listType
    ;

assignmentStatement
    : intAssigment EOL
    | booleanAssigment EOL
    | stringAssigment EOL
    | dotAssignment EOL
    | listIndexAssignment EOL
//  | choiceAssignment
    ;

dotAssignment
    : fieldAccessLH ASSIGN (STR|INT|BOOL|IDENTIFIER|expression)
    ;

// might never be used, deprecated by dotAssignment
listIndexAssignment
    : fieldAccessLH ASSIGN expression
    ;

//List element access by index, allows a.b[1][2].c[3].d.foo() on right side of =;
fieldAccess
    : IDENTIFIER (DOT IDENTIFIER | indexAccess)* (DOT actionCall)?
    ;

//List element access by index, allows a.b[1][2].c[3].d on left side of =; a[].b[].c[]
fieldAccessLH
    : IDENTIFIER (DOT IDENTIFIER | indexAccess)+
    ;

//Consider allowing AEXPR and actionCall in addition to (INT | IDENTIFIER)
indexAccess
    //: IDENTIFIER (DOT IDENTIFIER | LSBRACE (INT | IDENTIFIER) RSBRACE)* (DOT actionCall)?
    : (LSBRACE (INT | IDENTIFIER) RSBRACE)+
    ;

intAssigment
    : IDENTIFIER ASSIGN arithmeticExpression
    ;

booleanAssigment
    : IDENTIFIER ASSIGN booleanExpression
    ;

stringAssigment
    : IDENTIFIER ASSIGN STR
    ;

/*
choiceAssignment
    : (INT COLON)* LBRACE IDENTIFIER LPAREN (INT)* RPAREN RBRACE COMMA
    | IDENTIFIER LPAREN (IDENTIFIER | COMMA)* RPAREN
    | IDENTIFIER COLON LBRACE print RBRACE EOL
    ;*/

// Special body's
designBody
    : LBRACE (fieldRow)+ RBRACE
    ;

fieldRow
    : INTDCL IDENTIFIER EOL
    | BOOLDCL IDENTIFIER EOL
    | STRDCL IDENTIFIER EOL
    | LISTDCL COLON listType IDENTIFIER EOL
    | actionDeclaration EOL
    | IDENTIFIER IDENTIFIER EOL
    ;

//Primitive types
primitiveType
    : INTDCL | BOOLDCL | STRDCL
    ;

primitiveValue
    : INT | BOOL | STR
    ;

formalParameter
    : type IDENTIFIER
    ;

statement
    : ifStatement
    | whileStatement
    | foreach
    | assignmentStatement
    | print EOL
    | input EOL
    | expression EOL
    | returnStatement EOL
    | exitStatement EOL
    | randomCall EOL
    ;

sizeof
    : SIZEOF LPAREN IDENTIFIER RPAREN
    ;

expression
    : booleanExpression
    ;

arithmeticExpression
    : additive
    ;

booleanExpression
    : logor
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
    : pow EXP unaryMinus
    | unaryMinus
    ;

unaryMinus
    : MINUS arithmeticAtom
    | arithmeticAtom
    ;

arithmeticAtom
    : INT
    | sizeof
    | fieldAccess
    | actionCall
    | IDENTIFIER
    | LPAREN arithmeticExpression RPAREN
    | randomCall
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

booleanAtom
    : BOOL
    | IDENTIFIER
    | LPAREN booleanExpression RPAREN
    ;

ifStatement
    : IF LPAREN booleanExpression RPAREN normalBlock (elseifStatement)* (elseStatement)?
    ;

elseStatement
    : ELSE normalBlock
    ;

elseifStatement
    : ELSEIF LPAREN booleanExpression RPAREN normalBlock
    ;

whileStatement
    : WHILE LPAREN booleanExpression RPAREN normalBlock
    ;

foreach
    : FOREACH LPAREN IDENTIFIER IN IDENTIFIER RPAREN normalBlock
    ;

print
    : PRINT LPAREN (STR | booleanExpression ) (COMMA (STR | booleanExpression))* RPAREN
    ;

input
    : INPUT LPAREN IDENTIFIER RPAREN //TODO consider having an input type for the identifier
    ;