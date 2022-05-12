




	.section	.rodata
	.text
	.globl	buzz
	.type	buzz, @function
buzz:
.LFB7:
	.cfi_startproc
	endbr64	
	push	rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp	#,
	.cfi_def_cfa_register 6
# out.c:20:     printf("hej");
	mov esi, eax
	lea	rdi, .LC1[rip]	#,
	mov	eax, 0	#,
	call	printf@PLT	#
# out.c:21:     printf("farvel\n");
	mov esi, eax
	lea	rdi, .LC2[rip]	#,
	mov	eax, 0	#,
	call	printf@PLT	#

	mov esi, eax
	lea	rdi, .LC3[rip]	#,
	mov	eax, 0	#,
	call	printf@PLT	#
	mov eax, 5
	add eax, 3
# out.c:22: }
	call 	puts@PLT
	nop	
	pop	rbp	#
	.cfi_def_cfa 7, 8
	ret	
	.cfi_endproc
.LFE7:
	.size	buzz, .-buzz        #