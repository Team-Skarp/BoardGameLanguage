## Arithmetic Language

### Description

This language serves as a stepping stone towards our larger
group project in where we are learning about compilers.

The language should be able to deal with simple arithmetic operations
such as multiplication, addition, subtraction and so on.

It contains two datatypes floating point numbers and integers

### Getting started

To tryout the grammer with ANTLR, right click the Board.g4 file
and choose 'configure'

The output directory should be 

```
PATH_TO_THIS_FOLDER/Math-language/src/main/java/bogac
```

Leave 'location of imported grammer' and 'grammer file enconding' as blank

The package/namespace should be

```
antlr
```

### NASM
sudo apt-get install NASM
sudo apt-get install libc6-dev-i386
Compiling assembly requires NASM.
to compile, enter this command:
nasm -f elf64 -o out.o out.asm && ld out.o -o out && ./out

Compiling c requires GCC.
to compile, enter this command:
gcc out.c -o out && ./out