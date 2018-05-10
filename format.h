//
// Created by Elijah on 04.05.2018.
//

#ifndef ASSEMBLER_FORMAT_H
#define ASSEMBLER_FORMAT_H

#include "string.h"

#include <stdio.h>
#include <stdlib.h>


#define LD "ld"
#define ST "st"
#define LDC "ldc"
#define JMP "jmp"
#define BR "br"
#define ADD "add"
#define SUB "sub"
#define CMP "cmp"
#define RET "ret"


#define MAX_COMMAND_LEN 5
#define MAX_LABEL_LEN 100
#define CMDARRAYSIZE 100
#define MAXADDRESSSPACE 262144
#define BUFFER_SIZE 1000
#define WORD_BUFFER_SIZE 100


#endif //ASSEMBLER_FORMAT_H
