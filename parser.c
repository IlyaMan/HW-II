//
// Created by Elijah on 04.05.2018.
//

#include "parser.h"


int checkWithOutArguments(char *cmd) {
    if ((strcmp(cmd, ADD) == 0)
        || (strcmp(cmd, SUB) == 0)
        || (strcmp(cmd, ADD) == 0)
        || (strcmp(cmd, CMP) == 0)
        || (strcmp(cmd, RET) == 0)) {
        return 1;
    } else {
        return 0;
    }
};

int checkWithArguments(char *cmd) {
    if ((strcmp(cmd, LD) == 0)
        || (strcmp(cmd, ST) == 0)
        || (strcmp(cmd, LDC) == 0)
        || (strcmp(cmd, JMP) == 0)
        || (strcmp(cmd, BR) == 0)) {
        return 1;
    } else {
        return 0;
    }
};

char **splitLine(char *line) {
    const output_size = 3;
    int i = 0;
    int word = 0;
    int counter = 0;
    char *temp = (char *) calloc(MAX_LABEL_LEN, sizeof(char));
    int j = 0;
    char **parsedLine = (char **) calloc(output_size, sizeof(char **));
    for (int k = 0; k < output_size; k++) {
        parsedLine[k] = (char *) calloc(MAX_LABEL_LEN, sizeof(char));
    }
    while (line[i]) {

        if ((line[i] != ' ') && (line[i] != '\n')) {
            int flag1 = (counter == output_size);
            int flag2 = (line[i] == ';');
            if (flag1) {
                if (flag2) {
                    return parsedLine;
                } else {
                    printf("TOO MANY ARGUMENTS: %s", line);
                    return 0;
                }
            }
            if (0 == word) {
                j = 0;
                word = 1;
                if (flag2) {
                    return parsedLine;
                }
            }

            if (flag2) {
                strcpy(parsedLine[counter], temp);
                return parsedLine;
            }
            temp[j] = line[i];
            j++;
            if ('\n' == line[i] || strlen(line) - 1 == i) {
                strcpy(parsedLine[counter], temp);
                counter++;
                word = 0;
            }
        } else {
            if (1 == word) {
                strcpy(parsedLine[counter], temp);
                memset(temp, 0, MAX_LABEL_LEN * sizeof(char));
                j = 0;
                counter++;
                word = 0;
            } else {
                word = 0;
                memset(temp, 0, MAX_LABEL_LEN * sizeof(char));
                j = 0;
            }
        }

        i++;


    }
    return parsedLine;
}


CMD *Line(char **parsed) {
    if ((strlen(parsed[0]) == 0) && (strlen(parsed[1]) == 0) && (strlen(parsed[2]) == 0)) {
        return 0;
    }

    if (parsed[0][strlen(parsed[0]) - 1] == ':') {
        if (checkWithOutArguments(parsed[1])
            && (strlen(parsed[2]) > 0)
                ) {
            printf("TOO MANY AGRUMENTS\n");
            printf("%s %s %s \n", parsed[0], parsed[1], parsed[2]);
            return 0;

        }
        if (checkWithArguments(parsed[1])
            && (strlen(parsed[2]) <= 0)) {
            printf("TOO FEW AGRUMENTS\n");
            printf("%s %s %s \n", parsed[0], parsed[1], parsed[2]);
            return 0;
        }

    } else {
        if (strlen(parsed[2]) > 0) {
            printf("TOO MANY AGRUMENTS\n");
            printf("%s %s %s \n", parsed[0], parsed[1], parsed[2]);
            return 0;
        }
        if (checkWithArguments(parsed[0])
            && (strlen(parsed[1]) <= 0)) {
            printf("TOO FEW AGRUMENTS\n");
            printf("%s %s %s \n", parsed[0], parsed[1], parsed[2]);
            return 0;
        }
        if (checkWithOutArguments(parsed[0])
            && (strlen(parsed[1]) > 0)
                ) {
            printf("TOO MANY AGRUMENTS\n");
            printf("%s %s %s \n", parsed[0], parsed[1], parsed[2]);
            return 0;


        }

    }

    CMD *cmd = (CMD *) calloc(1, sizeof(CMD));

    if (parsed[0][strlen(parsed[0]) - 1] == ':') {
        parsed[0][strlen(parsed[0]) - 1] = '\0';
        strcpy(cmd->label, parsed[0]);
        if (!(checkWithArguments(parsed[1]) || checkWithOutArguments(parsed[1]))) {
            printf("UNKNOWN CMD:\n");
            printf("%s %s %s \n", parsed[0], parsed[1], parsed[2]);
            return 0;
        } else {
            strcpy(cmd->id, parsed[1]);
            strcpy(cmd->value, parsed[2]);
        }

    } else {
        strcpy(cmd->id, parsed[0]);
        strcpy(cmd->value, parsed[1]);
    }
    return cmd;
}

void parser(CMD *list, int *currentSize) {
    char *filename = "../program.txt";
    char buffer[BUFFER_SIZE];
    char word[WORD_BUFFER_SIZE];
    FILE *fptr;
    int counter = 0;

    if ((fptr = fopen(filename, "r")) == NULL) {
        printf("Error! opening file");
        exit(1);
    }

    while (fgets(buffer, sizeof(buffer), fptr) != NULL) {
        char **parsed = splitLine(buffer);
        if (parsed != 0) {
            CMD *cmd = Line(parsed);
            if (cmd) {
                list[counter] = *cmd;
                (*currentSize)++;
                counter++;
            }
        }
    }

    fclose(fptr);

}

