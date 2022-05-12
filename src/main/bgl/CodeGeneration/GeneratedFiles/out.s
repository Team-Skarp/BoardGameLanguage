	.file	"out.c"
	.intel_syntax noprefix
	.text
	.globl	main
	.section	.rodata
.LC0:
    .string	"true"
.LC1:
    .string	"false"
.LC2:
    .string	"%s\n"
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
	mov	DWORD PTR -24[rbp], edi
 	mov	QWORD PTR -36[rbp], rsi
    mov	DWORD PTR -8[rbp], 5
        # bool print
    mov eax, -1
	cmp	eax, 0
	jne	.L2
	lea	rax, .LC0[rip]
	jmp	.L3
.L2:
	lea	rax, .LC1[rip]
.L3:
    mov rsi, rax
    

    lea	rdi, .LC2[rip]
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
