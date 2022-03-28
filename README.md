## Arithmetic Language

### Description

This language serves as a stepping stone towards our larger
group project in where we are learning about compilers.

The language should be able to deal with simple arithmetic operations
such as multiplication, addition, subtraction and so on.

It contains two datatypes floating point numbers and integers

### Tokens

| **_Token_** | **_RegEx_**                                   |
|-------------|-----------------------------------------------|
| EXP         | `\^`                                          |
| MUL         | `\*`                                          |
| DIV         | `\/`                                          |
| ADD         | `\+`                                          |
| SUB         | `\-`                                          |
| MOD         | `\%`                                          |
| FNUM        | <code>^(0&#124;([1-9][0-9]*))?\.[0-9]+</code> |
| INUM        | `^[0-9]+`                                     |
| LPAREN      | `\(`                                          |
| RPAREN      | `\)`                                          |


# Setup

To run ANTLR4 on our grammer use the following commands inside intelliJ
terminal:

```console
$ export CLASSPATH="tools/antlr-4.9-complete.jar:$CLASSPATH"
```
```
$ alias antlr4='java -Xmx500M -cp "tools/antlr-4.9-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
$ alias grun='java -Xmx500M -cp "tools/antlr-4.9-complete.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'
```

## ANTLR4 help
https://github.com/antlr/antlr4/blob/master/doc/getting-started.md






