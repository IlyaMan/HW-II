#include <stdio.h>
#include "stack.h"
#include "cmd.h"
#include "parser.h"
#include "intepreter.h"
//char *cmds[] = {"ld", "st", "ldc", "add", "sub", "cmp", "jmp", "br", "ret"};


int main() {
    int i = 0;
    int *currentSize = (int *) calloc(1, sizeof(int));
    CMD *list = (CMD *) calloc(CMDARRAYSIZE, sizeof(CMD));
    parser(list, currentSize);
    while (i < *currentSize) {
//        printf("%s\n", list[i].id);
        i++;
    }
    interpreter(list, *currentSize);



    return 0;
}