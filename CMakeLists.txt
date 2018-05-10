cmake_minimum_required(VERSION 3.10)
project(assembler C)

set(CMAKE_C_STANDARD 11)

add_executable(assembler main.c stack.c stack.h format.h cmd.c cmd.h parser.c parser.h intepreter.c intepreter.h)