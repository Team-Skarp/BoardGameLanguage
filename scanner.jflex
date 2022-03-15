/* Package declarations and imports
 */

package scanner;
import static scanner.Token.*;

%%

%class Scanner
%type Token
%function nextToken

%eofval{
return new Token(EOF);
%eofval}

/* Makes the generated Yylex class public */
%public

/* Tell JFlex it should be standalone from CUP */
%standalone

/* Action code */
%{
   /*  Call me to say what you found */

%}

%%

/* Regular Expressions for tokens
 */

    ^[0-9]+    {return new Token(INUM, yytext());}

