grammar Board;

//Block structures
        SETUPBLC  : 'SETUP';
        RULESBLC  : 'RULES';
        GMLOOPBLC : 'GMLOOP';

//Declarations
        INTDCL      : 'int';
        BOOLDCL     : 'bool';
        STRINGDCL   : 'str' | 'string';
        DESIGNDCL   : 'design';

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
        RETURN  : 'return';
        FOR     : 'for';
        FOREACH : 'foreach';
        WHILE   : 'while';
        IN      : 'in';

//Special keywords
        FROM        : 'from';
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
        : EOF
        ;

        gameloop
        : EOF
        ;

        statements
        : ifstmnt
        | whilestmnt
        | foreach
        | EOF
        ;

        block
        : LBRACE (declarations|statements|block)* RBRACE
        ;

        //declarations
        declarations
        : dcltype EOL
        ;

        dcltype
        : INTDCL intasign
        | BOOLDCL boolasign
        | STRINGDCL stringasign
        | DESIGNDCL
        ;

        intasign
        : IDENTIFIER ASSIGN aexpr COMMA intasign
        | IDENTIFIER ASSIGN aexpr
        ;

        boolasign
        : IDENTIFIER ASSIGN bexpr COMMA boolasign
        | IDENTIFIER ASSIGN bexpr
        ;

        stringasign
        : IDENTIFIER ASSIGN STRING COMMA stringasign
        | IDENTIFIER ASSIGN STRING
        ;

        //arithmetic expression
        aexpr
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
        | LPAREN aexpr RPAREN
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
        : relational GTH aexpr
        | relational LTH aexpr
        | relational GTHEQL aexpr
        | relational LTHEQL aexpr
        | aexpr
        | batom
        ;

        not
        : NOT
        ;

        batom
        : BOOL
        | not batom
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

        //die at the bottom you piece of shit identifier
        IDENTIFIER  : [a-zA-Z][a-zA-Z0-9]*('_'+[a-zA-Z0-9]+)*;

