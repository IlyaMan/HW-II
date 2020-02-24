#include <stdio.h>
#include "stack.h"
#include "cmd.h"
#include "parser.h"
#include "intepreter.h"



int main() {
    int i = 0;
    int *currentSize = (int *) calloc(1, sizeof(int));
    CMD *list = (CMD *) calloc(CMDARRAYSIZE, sizeof(CMD));
    if (currentSize && list){
    }
    else{
        printf("MEMORY ALLOCATION ERROR");
    }
    parser(list, currentSize);
    while (i < *currentSize) {
        i++;
    }
    interpreter(list, *currentSize);



    return 0;
}