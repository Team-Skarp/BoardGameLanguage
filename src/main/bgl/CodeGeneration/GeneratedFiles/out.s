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
    .string	"%d\n"
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
    mov	DWORD PTR -8[rbp], 0
    # assignemnt
	mov eax, DWORD PTR -8[rbp]
add eax, 1

	mov	DWORD PTR -8[rbp],eax
 # while loop start
	jmp	.L4
.L3:
    # while loop block start
	    mov eax, DWORD PTR -8[rbp]
    mov	esi, eax
    

    lea	rdi, .LC2[rip]
	mov	eax, 0
	call	printf@PLT
    # assignemnt
	mov eax, DWORD PTR -8[rbp]
add eax, 1

	mov	DWORD PTR -8[rbp],eax

	# while loop block end
.L4:
# predicate
    mov eax, 0
	cmp	eax, 0
	je	.L3
	mov	eax, 0
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
