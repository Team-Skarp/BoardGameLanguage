Compiling assembly requires NASM.
to compile, enter this command: nasm -f elf64 -o out.o out.asm && ld out.o -o out && ./out"

Compiling c requires GCC.
to compile, enter this command: gcc out.c -o out && ./out