	.file	"out.c"
	.intel_syntax noprefix
	.text
	.globl	main
	.section .rodata
.LC0:
    .string	"true"
.LC1:
    .string	"false"
.LC2:
    .string	"%d\n"
.LC4:
	.string	"%d"
    .text
    .type	main, @function
main:
.LFB6:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	DWORD PTR -36[rbp], edi
 	mov	QWORD PTR -48[rbp], rsi
    mov	DWORD PTR -12[rbp], 4
.GAMELOOP:
	lea	rax, -12[rbp]
	mov	rsi, rax
	lea	rdi, .LC4[rip]
	mov	eax, 0
	call	__isoc99_scanf@PLT
	push 5
	call fizzbuzz
	mov	eax, 0

    jmp .GAMELOOP
  	leave
 	mov	eax, 0
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE6:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 9.4.0-1ubuntu1~20.04.1) 9.4.0"
	.section	.note.GNU-stack,"",@progbits
	.section	.note.gnu.property,"a"
	.align 8
	.long	 1f - 0f
	.long	 4f - 1f
	.long	 5
		.section .rodata
	.text
	.globl	fizzbuzz
	.type	fizzbuzz, @function
fizzbuzz:
.LFB8:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	    mov	DWORD PTR -20[rbp], 0

    mov eax, DWORD PTR 16[rbp]
    mov	DWORD PTR -20[rbp],  eax

        mov eax, DWORD PTR -20[rbp]
    mov	esi, eax
    lea	rdi, .LC2[rip]
	mov	eax, 0
	call printf@PLT

	call 	puts@PLT
	nop
	pop	rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE8:
	.size	fizzbuzz, .-fizzbuzz

0:
	.string	 "GNU"
1:
	.align 8
	.long	 0xc0000002
	.long	 3f - 2f
2:
	.long	 0x3
3:
	.align 8
4:
