// Define a grammar called arithm
grammar Arithmetic;

FLOAT   : [0-9]+ ('.'[0-9]+)?;
INT     : [0-9]+;

MOD     : '%';
PLUS    : '+';
MINUS   : '-';
MULT    : '*';
DIV     : '/';

LPAREN  : '(';
RPAREN  : ')';
WS      : [ \t\r\n] -> skip;    //Tells antler to skip over these characters
EOL     : ';';

prog
    : statements;

statements
    : statement EOL
    | statement EOL statements
    ;

statement
    : modulus
    ;

modulus
    : modulus MOD addOrSub
    | addOrSub
    ;

addOrSub
    : addOrSub PLUS multOrDiv
    | addOrSub MINUS multOrDiv
    | multOrDiv
    ;

multOrDiv
    : multOrDiv MULT atom
    | multOrDiv DIV atom
    | atom
    ;

atom
    : FLOAT
    | INT
    | LPAREN statement RPAREN
    ;
