//
// Created by Elijah on 02.05.2018.
//
#include "stack.h"


Stack *spawnStack() {
    Stack *stack = (Stack *) malloc(sizeof(Stack));
    stack->top = 0;
    stack->size = 0;
    return stack;
}

void pushStack(Stack *stack, int value) {
    Item *item = (Item *) malloc(sizeof(Item));
    item->value = value;
    item->previous = stack->top;
    stack->top = item;
    stack->size += 1;
}


int popStack(Stack *stack) {
    if (stack->size != 0) {
        Item *item = stack->top;
        free(stack->top);
        stack->top = item->previous;
        stack->size -= 1;
        return item->value;
    } else {
        printf("Stack is empty. You can't take elements from it!");
        return 0;
    }
}

void clearStack(Stack *stack) {
    while (stack->size > 0) {
        Item *t = stack->top->previous;
        free(stack->top);
        stack->top = t;
        stack->size -= 1;

    }
}
