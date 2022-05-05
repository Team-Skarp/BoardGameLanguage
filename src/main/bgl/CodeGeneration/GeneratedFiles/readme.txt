Compiling assembly requires NASM or GCC depending on version.
to compile, enter this command: nasm -f elf64 -o out.o out.asm && ld out.o -o out && ./out"

Compiling c requires GCC.
to compile, enter this command: gcc -S out.c && gcc out.s -o out && ./out


