	.file	"out.c"
	.intel_syntax noprefix
	.text
	.globl	main
	.type main, @function
	.section .rodata
.LC0:
    .string	"true"
.LC1:
    .string	"false"
.LC3:
    .string	"Hans"
.LC5:
    .string	"Jakob"
.LC6:
    .string	"Welcome to the greatest game ever!\n"
.LC7:
    .string	"It is "
.LC9:
    .string	" turn\n"
.LC10:
    .string	"enter 1 to double your attackpower, or type 0 to expend your attackpower to attack\n"
.LC12:
	.string	"%d"
.LC13:
    .string	"Doubled your attack!\n"
.LC14:
    .string	"Attacked!\n"
.LC16:
    .string	", health: "
.LC17:
    .string	"%d"
.LC18:
    .string	", attack: "
.LC19:
    .string	"%d\n"
.LC21:
    .string	", health: "
.LC22:
    .string	"%d"
.LC23:
    .string	", attack: "
.LC24:
    .string	"%d\n"
.LC25:
    .string	"It is "
.LC27:
    .string	" turn\n"
.LC29:
	.string	"%d"
.LC30:
    .string	"Doubled your attack!\n"
.LC31:
    .string	"Attacked!\n"
.LC32:
    .string	"You winn!\n"
.LC34:
	.string	"%d"
.LC35:
    .string	"You winn!\n"
.LC37:
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
	sub rsp, 16
	mov	DWORD PTR -40[rbp], edi
 	mov	QWORD PTR -52[rbp], rsi
    mov	DWORD PTR -8[rbp], 1
    mov	DWORD PTR -12[rbp], 10000
    mov	DWORD PTR -16[rbp], 1
    mov	DWORD PTR -20[rbp], 1
    mov	DWORD PTR -24[rbp], 10000
    mov	esi, eax    

    lea	rdi, .LC6[rip]
	mov	eax, 0
	call printf@PLT
.GAMELOOP:
    mov	esi, eax    

    lea	rdi, .LC7[rip]
	mov	eax, 0
	call printf@PLT
    

    lea	rdi, .LC3[rip]
	mov	eax, 0
	call printf@PLT
    mov	esi, eax    

    lea	rdi, .LC9[rip]
	mov	eax, 0
	call printf@PLT
    mov	esi, eax    

    lea	rdi, .LC10[rip]
	mov	eax, 0
	call printf@PLT
	lea	rax, -16[rbp]
	mov	rsi, rax
	lea	rdi, .LC12[rip]
	mov	eax, 0
	call	__isoc99_scanf@PLT
    

	mov eax, -1
	mov ebx, 1
	cmp ebx, DWORD PTR -16[rbp]
	jne .L8
	mov eax, 0
.L8:

	cmp	eax, 0
	jne	.L7
	    mov	esi, eax    

    lea	rdi, .LC13[rip]
	mov	eax, 0
	call printf@PLT
	mov eax, 0
mov eax, DWORD PTR -8[rbp]
imul eax, 2
cmp ebx, eax

	mov	DWORD PTR -8[rbp],eax

	jmp	.L6
 .L7:
    mov	esi, eax    

    lea	rdi, .LC14[rip]
	mov	eax, 0
	call printf@PLT
	mov eax, 0
mov eax, DWORD PTR -24[rbp]
sub eax, DWORD PTR -8[rbp]
cmp ebx, eax

	mov	DWORD PTR -24[rbp],eax
	mov eax, 1
	mov	DWORD PTR -8[rbp],eax

 .L6:
    

    lea	rdi, .LC3[rip]
	mov	eax, 0
	call printf@PLT
    mov	esi, eax    

    lea	rdi, .LC16[rip]
	mov	eax, 0
	call printf@PLT
    mov eax, DWORD PTR -12[rbp]
    mov	esi, eax
    

    lea	rdi, .LC17[rip]
	mov	eax, 0
	call printf@PLT
    mov	esi, eax    

    lea	rdi, .LC18[rip]
	mov	eax, 0
	call printf@PLT
    mov eax, DWORD PTR -8[rbp]
    mov	esi, eax
    

    lea	rdi, .LC19[rip]
	mov	eax, 0
	call printf@PLT
    

    lea	rdi, .LC5[rip]
	mov	eax, 0
	call printf@PLT
    mov	esi, eax    

    lea	rdi, .LC21[rip]
	mov	eax, 0
	call printf@PLT
    mov eax, DWORD PTR -24[rbp]
    mov	esi, eax
    

    lea	rdi, .LC22[rip]
	mov	eax, 0
	call printf@PLT
    mov	esi, eax    

    lea	rdi, .LC23[rip]
	mov	eax, 0
	call printf@PLT
    mov eax, DWORD PTR -20[rbp]
    mov	esi, eax
    

    lea	rdi, .LC24[rip]
	mov	eax, 0
	call printf@PLT
    mov	esi, eax    

    lea	rdi, .LC25[rip]
	mov	eax, 0
	call printf@PLT
    

    lea	rdi, .LC5[rip]
	mov	eax, 0
	call printf@PLT
    mov	esi, eax    

    lea	rdi, .LC27[rip]
	mov	eax, 0
	call printf@PLT
	lea	rax, -16[rbp]
	mov	rsi, rax
	lea	rdi, .LC29[rip]
	mov	eax, 0
	call	__isoc99_scanf@PLT
    

	mov eax, -1
	mov ebx, 1
	cmp ebx, DWORD PTR -16[rbp]
	jne .L18
	mov eax, 0
.L18:

	cmp	eax, 0
	jne	.L17
	    mov	esi, eax    

    lea	rdi, .LC30[rip]
	mov	eax, 0
	call printf@PLT
	mov eax, 0
mov eax, DWORD PTR -20[rbp]
imul eax, 2
cmp ebx, eax

	mov	DWORD PTR -20[rbp],eax

	jmp	.L16
 .L17:
    mov	esi, eax    

    lea	rdi, .LC31[rip]
	mov	eax, 0
	call printf@PLT
	mov eax, 0
mov eax, DWORD PTR -12[rbp]
sub eax, DWORD PTR -20[rbp]
cmp ebx, eax

	mov	DWORD PTR -12[rbp],eax
	mov eax, 1
	mov	DWORD PTR -20[rbp],eax

 .L16:
    

	mov eax, -1
	mov ebx, 0
	cmp ebx, DWORD PTR -24[rbp]
	jl .L25
	mov eax, 0
.L25:

	cmp	eax, 0
	jne	.L24
	    mov	esi, eax    

    lea	rdi, .LC32[rip]
	mov	eax, 0
	call printf@PLT
	lea	rax, -16[rbp]
	mov	rsi, rax
	lea	rdi, .LC34[rip]
	mov	eax, 0
	call	__isoc99_scanf@PLT

	jmp	.L23
 .L24:
 .L23:
    

	mov eax, -1
	mov ebx, 0
	cmp ebx, DWORD PTR -12[rbp]
	jl .L31
	mov eax, 0
.L31:

	cmp	eax, 0
	jne	.L30
	    mov	esi, eax    

    lea	rdi, .LC35[rip]
	mov	eax, 0
	call printf@PLT
	lea	rax, -16[rbp]
	mov	rsi, rax
	lea	rdi, .LC37[rip]
	mov	eax, 0
	call	__isoc99_scanf@PLT

	jmp	.L29
 .L30:
 .L29:

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
