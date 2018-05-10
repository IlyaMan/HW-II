//
// Created by Elijah on 04.05.2018.
//

#ifndef ASSEMBLER_CMD_H
#define ASSEMBLER_CMD_H

#include "format.h"


typedef struct CMD {
    char id[MAX_COMMAND_LEN];
    char *value[MAX_LABEL_LEN];
    char label[MAX_LABEL_LEN];
} CMD;

int findLabel(CMD *list, char *label);

#endif //ASSEMBLER_CMD_H
