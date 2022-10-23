cmake_minimum_required(VERSION 3.10)

project(logbook C)

file(GLOB SOURCE *.c)
add_executable(logbook.out ${SOURCE})