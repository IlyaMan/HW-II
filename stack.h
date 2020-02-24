//
// Created by Elijah on 02.05.2018.
//

#ifndef ASSEMBLER_STACK_H
#define ASSEMBLER_STACK_H

#include <stdlib.h>
#include <stdio.h>


typedef struct Item {
    int value;
    struct Item *previous;
} Item;


typedef struct {
    Item *top;
    int size;
} Stack;


Stack *spawnStack();

void pushStack(Stack *stack, int value);

int popStack(Stack *stack);

void clearStack(Stack *stack);


#endif //ASSEMBLER_STACK_H
