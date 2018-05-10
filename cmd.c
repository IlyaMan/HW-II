//
// Created by Elijah on 04.05.2018.
//

#include "cmd.h"


int findLabel(CMD *list, char *label) {
    for (int i = 0; i < CMDARRAYSIZE; i++) {
        if (strcmp(label, list[i].label) == 0) {
            return i;
        }
    }
    return -1;
}
