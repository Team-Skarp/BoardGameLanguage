
;HEADER START
quit:
    mov       rax, 60                 ; system call for exit
    xor       rdi, rdi                ; exit code 0
    syscall                           ; invoke operating system to exit
    
print:
    mov       rax, 1                  ; system call for write
    mov       rdi, 1                  ; file handle 1 is stdout
    syscall
    ret


section .text                         ; flow of the program
    global _start

_start:
;HEADER END
;STRING BUILDER START
    mov       rdx, 4                  ; number of bytes
    mov       rsi, var0              ; address of string to output
    call      print
    mov       rdx, 4                  ; number of bytes
    mov       rsi, var1              ; address of string to output
    call      print


;STRING BUILDER END;
;DATA SECTION START
    call      quit
section .data                         ; allocate data to memory
    var0 db "hej",10
    var1 db 57+56,10
;DATA SECTION END