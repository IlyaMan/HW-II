//
// Created by Elijah on 10.05.2018.
//

#include "intepreter.h"
#include "stack.h"


void interpreter(CMD *list, int size) {
    int i = 0;
    int ADDRESSSPACE[MAXADDRESSSPACE] = {0};
    Stack *stack = spawnStack();

    while (i < size) {
        if (strcmp(list[i].id, RET) == 0) {
            if (stack->size > 0){
                printf("%d WAS ON THE TOP OF THE STACK, WHEN PROGRAM CORRECTLY ENDED", popStack(stack));
            }
            else {
                printf("PROGRAM ENDED CORRECTLY. STACK WAS EMPTY");
            }

            exit(0);
        }
        if (strcmp(list[i].id, JMP) == 0) {
            if ((i = findLabel(list, list[i].value)) != -1) {
                continue;
            } else {
                printf("INVALID LABEL: %s\n", list[i].value);
                exit(0);
            }
        }
        if (strcmp(list[i].id, BR) == 0) {
            if ((stack->size > 0)){
                int a = popStack(stack);
                pushStack(stack, a);
                if (a != 0) {
                    if ((i = findLabel(list, list[i].value)) != -1) {
                        continue;
                    } else {
                        printf("INVALID LABEL: %s\n", list[i].value);
                        exit(0);
                    }
                }
            }

        }

        if (strcmp(list[i].id, LDC) == 0) {
            pushStack(stack, atoi(list[i].value));
        }

        if (strcmp(list[i].id, ST) == 0) {
            ADDRESSSPACE[atoi(list[i].value)] = popStack(stack);
        }

        if (strcmp(list[i].id, LD) == 0) {
            pushStack(stack, ADDRESSSPACE[atoi(list[i].value)]);
        }

        if (strcmp(list[i].id, ADD) == 0) {
            int a = popStack(stack);
            int b = popStack(stack);
            pushStack(stack, b);
            pushStack(stack, a);
            pushStack(stack, a + b);
        }
        if (strcmp(list[i].id, SUB) == 0) {
            int a = popStack(stack);
            int b = popStack(stack);
            pushStack(stack, b);
            pushStack(stack, a);
            pushStack(stack, (a - b));
        }
        if (strcmp(list[i].id, CMP) == 0) {

            int a = popStack(stack);
            int b = popStack(stack);
            pushStack(stack, b);
            pushStack(stack, a);
            if (a == b) {
                pushStack(stack, 0);
            };
            if (a > b) {
                pushStack(stack, 1);
            };
            if (a < b) {
                pushStack(stack, -1);
            };


        }

        i++;
    }


}