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

# Setup

To recompile the Scanner class run the ant ```genScanner``` task

The scanner can be run on input files using the command:

```
java Scanner.java input
```






