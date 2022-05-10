	.file	"out.c"
	.text
	.section	.rodata
.LC0:
	.string	"%c\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB6:
	.cfi_startproc
	endbr64
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$64, %rsp
	movl	%edi, -52(%rbp)
	movq	%rsi, -64(%rbp)
	movl	$1, -28(%rbp)
	movl	$0, -24(%rbp)
	movq	$0, -16(%rbp)
	movl	$3, %edi
	call	malloc@PLT
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rax
	movabsq	$2334102026254443880, %rcx
	movq	%rcx, (%rax)
	movl	$560425316, 8(%rax)
	movb	$0, 12(%rax)
	movq	-16(%rbp), %rax
	movq	%rax, %rdi
	call	puts@PLT
	movq	-16(%rbp), %rax
	movq	%rax, %rdi
	call	puts@PLT
	movl	$1, -36(%rbp)
	movl	$0, -32(%rbp)
	movl	$8, -20(%rbp)
	jmp	.L2
.L6:
	movl	-32(%rbp), %eax
	movslq	%eax, %rdx
	movq	-16(%rbp), %rax
	addq	%rdx, %rax
	movq	%rax, -8(%rbp)
	jmp	.L3
.L4:
	movq	-8(%rbp), %rax
	movzbl	(%rax), %eax
	movsbl	%al, %eax
	movl	%eax, %esi
	leaq	.LC0(%rip), %rdi
	movl	$0, %eax
	call	printf@PLT
	cmpl	$0, -36(%rbp)
	sete	%al
	movzbl	%al, %eax
	movl	%eax, -36(%rbp)
.L3:
	cmpl	$0, -36(%rbp)
	jne	.L4
	cmpl	$0, -36(%rbp)
	sete	%al
	movzbl	%al, %eax
	movl	%eax, -36(%rbp)
	addl	$1, -32(%rbp)
.L2:
	cmpl	$0, -36(%rbp)
	je	.L5
	movl	-32(%rbp), %eax
	cmpl	-20(%rbp), %eax
	jne	.L6
.L5:
	movl	$0, %eax
	leave
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
