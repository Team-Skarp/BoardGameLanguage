grammar Board;

//Block structures
SETUPBLC  : 'SETUP';
RULESBLC  : 'RULES';
GMLOOPBLC : 'GMLOOP';

//Declarations
INTDCL      : 'int';
BOOLDCL     : 'bool';
STRINGDCL   : 'str';
DESIGNDCL   : 'design' | 'string';
LISTDCL     : 'list';

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
TILE_EVENT  : 'eventType';
IN          : 'in';
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
    : SETUPBLC block
    ;

rules
    : RULESBLC LBRACE action choice special RBRACE
    ;

gameloop
    : EOF
    ;

special
    : SPECIAL IDENTIFIER eventType LPAREN IDENTIFIER COMMA IDENTIFIER RPAREN block
    ;

eventType
    : ON_LAND
    | ON_LEAVE
    | ON_VISIT
    ;

choice
    : CHOICE IDENTIFIER LPAREN IDENTIFIER RPAREN block
    ;

action
    : ACTION IDENTIFIER LPAREN IDENTIFIER RPAREN block
    ;

//declarations
declarations
    : dcltype EOL
    ;

dcltype
    : INTDCL iAssign EOL
    | BOOLDCL bAssign EOL
    | STRINGDCL sAssign EOL
    | DESIGNDCL dAssign
    | LISTDCL lAssign
    ;

statements
    : ifstmnt
    | whilestmnt
    | foreach
    | EOF
    ;

block
    : LBRACE (declarations|statements|block|lAssign|print)* RBRACE
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
    | STRINGDCL
    //| IDENTIFIER    //This identifier needs to be declared before it can be used here
    ;

lAssign
    : LISTDCL COLON IDENTIFIER ASSIGN LSBRACE (IDENTIFIER|COMMA)* RSBRACE
    | LISTDCL COLON IDENTIFIER IDENTIFIER LSBRACE INT RSBRACE
    ;

iAssign
    : IDENTIFIER ASSIGN aExpr COMMA iAssign
    | IDENTIFIER ASSIGN aExpr
    ;

bAssign
    : IDENTIFIER ASSIGN bexpr COMMA bAssign
    | IDENTIFIER ASSIGN bexpr
    ;

sAssign
    : IDENTIFIER ASSIGN STRING COMMA sAssign
    | IDENTIFIER ASSIGN STRING
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
    : IF LPAREN bexpr RPAREN block
    | IF LPAREN bexpr RPAREN block elsestmnt
    ;

elsestmnt
    : ELSE block
    | ELSE ifstmnt
    ;

whilestmnt
    : WHILE LPAREN bexpr RPAREN block
    ;

foreach
    : FOREACH IDENTIFIER IN IDENTIFIER block
    ;

print
    : PRINT LPAREN (block|COMMA|STRING|INT)* RPAREN EOL
    ;

//die at the bottom you piece of shit identifier
IDENTIFIER  : [a-zA-Z][a-zA-Z0-9]*('_'+[a-zA-Z0-9]+)*;