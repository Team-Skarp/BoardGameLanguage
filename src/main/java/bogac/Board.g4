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


//Design declerations
DESIGNDCL   : 'design';

//Special decleration
ACTIONDCL   : 'action';
CHOICEDCL   : 'choice';

//Primitive types
INT     : [0-9]+;
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

NEWLINE : '\n'      -> skip;
WS      : [ \t\r\n] -> skip;    //Tells antler to skip over these characters
EOL     : ';';

game
    : setup rules gameloop
    ;

setup
    : SETUPBLC setupBlock
    ;

rules
    : EOF
    ;

gameloop
    : EOF
    ;

setupBlock
    : LBRACE (normalDeclaration | designDeclaraion | statements | setupBlock )* RBRACE
    ;
normalBlock
    : LBRACE (normalDeclaration | statements | normalBlock )* RBRACE
    ;

//Primitive type decleration
normalDeclaration
    : integerDeclaration EOL
    | booleanDeclaration EOL
    | stringDeclaration EOL
    | listDeclaration EOL
    | actionDeclaration
    | specialDeclaration
    | choiceDeclaration
    ;

//Special and choice declarations should only be found in Rules block NOT IMPLEMENTED
specialDeclaration
    : SPECIAL IDENTIFIER TILE_EVENT LPAREN IDENTIFIER COMMA IDENTIFIER RPAREN normalBlock
    ;

choiceDeclaration
    : CHOICEDCL IDENTIFIER LPAREN IDENTIFIER RPAREN normalBlock //Should have a special choice block
    ;

actionDeclaration
    : ACTIONDCL IDENTIFIER LPAREN formalParameters RPAREN (COLON primitiveType)? normalBlock
    ;

//Design declerations should only appear in SETUP block
designDeclaraion
    : DESIGNDCL IDENTIFIER (FROM IDENTIFIER)? designBody
    ;

listDeclaration
    : LISTDCL COLON IDENTIFIER ASSIGN LSBRACE (IDENTIFIER|COMMA)* RSBRACE
    | LISTDCL COLON IDENTIFIER IDENTIFIER LSBRACE INT RSBRACE
    ;


integerDeclaration
    : INTDCL IDENTIFIER ASSIGN aExpr COMMA integerDeclaration
    | INTDCL IDENTIFIER ASSIGN aExpr
    ;

booleanDeclaration
    : BOOLDCL IDENTIFIER ASSIGN bexpr COMMA booleanDeclaration
    | BOOLDCL IDENTIFIER ASSIGN bexpr
    ;

stringDeclaration
    : STRDCL IDENTIFIER ASSIGN STRING COMMA stringDeclaration
    | STRDCL IDENTIFIER ASSIGN STRING
    ;

// Special body's
designBody
    : LBRACE (fieldRow)* RBRACE
    ;


//Primitive types
primitiveType
    : INTDCL | BOOLDCL | STRDCL
    ;

fieldRow
    : fieldType IDENTIFIER EOL
    ;

fieldType
    : INTDCL
    | BOOLDCL
    | STRDCL
    //| IDENTIFIER    //This identifier needs to be declared before it can be used here
    ;


formalParameters
    : primitiveType COLON IDENTIFIER
    | primitiveType COLON IDENTIFIER COMMA formalParameters
    ;


statements
    : ifstmnt
    | whilestmnt
    | foreach
    | EOF
    ;

//arithmetic expression
aExpr
    : additive+
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
    : pow EXP aatom
    | aatom
    ;

aatom
    : INT
    | LPAREN aExpr RPAREN
    ;

//boolean expressions
bexpr
    : logor+
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
    : relational GTH aExpr
    | relational LTH aExpr
    | relational GTHEQL aExpr
    | relational LTHEQL aExpr
    | aExpr
    | batom
    ;

not
    : NOT
    ;

batom
    : BOOL
    | NOT batom
    | LPAREN bexpr RPAREN
    ;

ifstmnt
    : IF LPAREN bexpr RPAREN normalBlock
    | IF LPAREN bexpr RPAREN normalBlock elsestmnt
    ;

elsestmnt
    : ELSE normalBlock
    | ELSE ifstmnt
    ;

whilestmnt
    : WHILE LPAREN bexpr RPAREN normalBlock
    ;

foreach
    : FOREACH IDENTIFIER IN IDENTIFIER normalBlock
    ;

//die at the bottom you piece of shit identifier
IDENTIFIER  : [a-zA-Z][a-zA-Z0-9]*('_'+[a-zA-Z0-9]+)*;