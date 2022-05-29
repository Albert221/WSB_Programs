#ifndef _log_h
#define _log_h

#include <stdbool.h>

typedef struct Log {
    char* aircraftIdent;
    char* routeFrom;
    char* routeTo;
    bool vfrNight;
    int totalDurationMinutes;
} Log;

Log* new_log(
    char* aircraftIdent,
    char* routeFrom,
    char* routeTo,
    bool vfrNight,
    int totalDurationMinutes);

void log_print(Log* log);

#endif