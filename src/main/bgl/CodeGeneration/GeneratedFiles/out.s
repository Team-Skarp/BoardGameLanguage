	.file	"out.c"
	.text
	.section	.rodata
.LC0:
	.string	"true"
.LC1:
	.string	"false"
.LC2:
	.string	"%s%d%s\n"
.LC3:
	.string	"%s%d%s\n\n\n"
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
	subq	$48, %rsp
	movl	%edi, -36(%rbp)
	movq	%rsi, -48(%rbp)
	movb	$1, -26(%rbp)
	movb	$0, -25(%rbp)
	movzbl	-25(%rbp), %eax
	movb	%al, -26(%rbp)
	movl	$5, -24(%rbp)
	movl	$10, -20(%rbp)
	movl	-20(%rbp), %eax
	movl	%eax, -24(%rbp)
	movl	$14, %edi
	call	malloc@PLT
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rax
	movabsq	$8391086215246539110, %rsi
	movq	%rsi, (%rax)
	movl	$1735289202, 8(%rax)
	movb	$0, 12(%rax)
	movl	$16, %edi
	call	malloc@PLT
	movq	%rax, -8(%rbp)
	movq	-8(%rbp), %rax
	movabsq	$7863395374866851187, %rsi
	movq	%rsi, (%rax)
	movl	$1634956133, 8(%rax)
	movw	$25959, 12(%rax)
	movb	$0, 14(%rax)
	movq	-8(%rbp), %rax
	movq	%rax, -16(%rbp)
	cmpb	$0, -26(%rbp)
	je	.L2
	leaq	.LC0(%rip), %rax
	jmp	.L3
.L2:
	leaq	.LC1(%rip), %rax
.L3:
	movq	-16(%rbp), %rcx
	movl	-24(%rbp), %edx
	movq	%rax, %rsi
	leaq	.LC2(%rip), %rdi
	movl	$0, %eax
	call	printf@PLT
	cmpb	$0, -25(%rbp)
	je	.L4
	leaq	.LC0(%rip), %rax
	jmp	.L5
.L4:
	leaq	.LC1(%rip), %rax
.L5:
	movq	-8(%rbp), %rcx
	movl	-20(%rbp), %edx
	movq	%rax, %rsi
	leaq	.LC3(%rip), %rdi
	movl	$0, %eax
	call	printf@PLT
	movb	$1, -25(%rbp)
	movl	$50, -20(%rbp)
	movq	-8(%rbp), %rax
	movl	$6, %esi
	movq	%rax, %rdi
	call	realloc@PLT
	movq	%rax, -8(%rbp)
	movq	-8(%rbp), %rax
	movl	$1835886701, (%rax)
	movb	$0, 4(%rax)
	cmpb	$0, -26(%rbp)
	je	.L6
	leaq	.LC0(%rip), %rax
	jmp	.L7
.L6:
	leaq	.LC1(%rip), %rax
.L7:
	movq	-16(%rbp), %rcx
	movl	-24(%rbp), %edx
	movq	%rax, %rsi
	leaq	.LC2(%rip), %rdi
	movl	$0, %eax
	call	printf@PLT
	cmpb	$0, -25(%rbp)
	je	.L8
	leaq	.LC0(%rip), %rax
	jmp	.L9
.L8:
	leaq	.LC1(%rip), %rax
.L9:
	movq	-8(%rbp), %rcx
	movl	-20(%rbp), %edx
	movq	%rax, %rsi
	leaq	.LC2(%rip), %rdi
	movl	$0, %eax
	call	printf@PLT
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
