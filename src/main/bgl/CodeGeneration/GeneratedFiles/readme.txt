Compiling NASMassembly requires NASM.
to compile, enter this command: nasm -f elf64 -o out.o out.asm && ld out.o -o out && ./out"

Compiling c requires GCC.
to compile, enter this command: gcc -S out.c && gcc out.s -o out && ./out

compiling GNUassembly requires gcc on wsl ubuntu: 
gcc out.s -o out && ./out




//Notes: gcc -S out.c -masm=intel -fverbose-asm && gcc out.s -o out && ./out