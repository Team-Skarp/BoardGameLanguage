	.file	"out.c"
	.intel_syntax noprefix
	.text
	.globl	main
	.section	.rodata
.LC0:
    .string	"true"
.LC1:
    .string	"false"
.LC3:
	.string	"%d"
.LC4:
    .string	"%s\n"
.LC5:
    .string	"hej\n"
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
	mov	DWORD PTR -28[rbp], edi
 	mov	QWORD PTR -40[rbp], rsi
mov	BYTE PTR -8[rbp], -1
    mov	DWORD PTR -12[rbp], 1
    lea rax, -12[rbp]
    mov	rsi, rax
    lea	rdi, .LC3[rip]
    mov	eax, 0
    call	__isoc99_scanf@PLT
    mov	BYTE PTR -8[rbp], -1
    cmp DWORD PTR -12[rbp], 0
    jle .L3
    mov	BYTE PTR -8[rbp], 0
.L3:
	cmp	BYTE PTR -8[rbp], -1
	je	.L5
	lea	rax, .LC0[rip]
	jmp	.L6
.L5:
	lea	rax, .LC1[rip]
.L6:
    mov rsi, rax
    

    lea	rdi, .LC4[rip]
	mov	eax, 0
	call printf@PLT
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
		.section	.rodata
	.text
	.globl	fizz
	.type	fizz, @function
fizz:
.LFB8:
	.cfi_startproc
	endbr64
	push	rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp	#,
	.cfi_def_cfa_register 6
        mov	esi, eax    

    lea	rdi, .LC5[rip]
	mov	eax, 0
	call printf@PLT

	call 	puts@PLT
	nop
	pop	rbp	#
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE8:
	.size	fizz, .-fizz

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
