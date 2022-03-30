grammar Board;

//Block structures
SETUPBLC  : 'SETUP';
RULESBLC  : 'RULES';
GMLOOPBLC : 'GMLOOP';

//Declarations
INTDCL      : 'int';
BOOLDCL     : 'bool';
STRDCL      : 'str';
DESIGNDCL   : 'design';

//Primitive types
INTVAL      : [0-9]+;
BOOLVAL     : 'True' | 'False';
STRVAL      : '"' ('\\' ["\\] | ~["\\\r\n])* '"';

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
RETURN  : 'return';
FOR     : 'for';
FOREACH : 'foreach';
WHILE   : 'while';

//Special keywords
FROM        : 'from';
TILE_EVENT  : 'event';
ON_LAND     : 'onLand';
ON_LEAVE    : 'onLeave';
ON_VISIT    : 'onVisit';
SPECIAL     : 'special';
UNI_DIR     : 'uni';
BI_DIR      : 'bi';
STATIC_DIR  : 'static';

CHOICE  : 'choice';
ACTION  : 'action';
PRINT   : 'print';

//Delimiters
LPAREN      : '(';
RPAREN      : ')';
LBRACE      : '{';
RBRACE      : '}';
COMMA       : ',';

NEWLINE : '\n'      -> skip;
WS      : [ \t\r\n] -> skip;    //Tells antler to skip over these characters
EOL     : ';';

game
    : setup rules gameloop
    ;

setup
    : SETUPBLC block
    ;

rules
    : RULESBLC LBRACE action choice special RBRACE
    ;

gameloop
    : EOF
    ;

special
    : IDENTIFIER event LPAREN IDENTIFIER ',' IDENTIFIER RPAREN block
    ;

choice
    : IDENTIFIER LPAREN IDENTIFIER RPAREN block
    ;

action
    : IDENTIFIER LPAREN IDENTIFIER RPAREN block
    ;

event
    : ON_LAND
    | ON_LEAVE
    | ON_VISIT
    ;

statements
    : ifstmnt
    | EOF
    ;

block
    : LBRACE (declarations|statements|block)* RBRACE
    ;

//declarations
declarations
    : INTDCL iAssign
    | BOOLDCL bAssign
    | STRDCL sAssign
    | DESIGNDCL dAssign
    ;

dAssign
    : IDENTIFIER (FROM IDENTIFIER)? dBlock
    ;

dBlock
    : LBRACE (fieldRow)* RBRACE
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

iAssign
    : IDENTIFIER ASSIGN aExpr COMMA iAssign
    | IDENTIFIER ASSIGN aExpr
    ;

bAssign
    : IDENTIFIER ASSIGN bExpr COMMA bAssign
    | IDENTIFIER ASSIGN bExpr
    ;

sAssign
    : IDENTIFIER ASSIGN STRVAL COMMA sAssign
    | IDENTIFIER ASSIGN STRVAL
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
    : INTVAL
    | LPAREN aExpr RPAREN
    ;

//boolean expressions
bExpr
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

batom
    : BOOLVAL
    | NOT batom
    | LPAREN bExpr RPAREN
    ;

ifstmnt
    : IF LPAREN bExpr RPAREN block
    | IF LPAREN bExpr RPAREN block elsestmnt
    ;
elsestmnt
    : ELSE block
    | ELSE ifstmnt
    ;

//die at the bottom you piece of shit identifier
IDENTIFIER  : [a-zA-Z][a-zA-Z0-9]*('_'+[a-zA-Z0-9]+)*;