#include "log.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

Log* new_log(
    char* aircraftIdent,
    char* routeFrom,
    char* routeTo,
    bool vfrNight,
    int totalDurationMinutes)
{
    Log* log = malloc(sizeof(Log));
    log->aircraftIdent = strdup(aircraftIdent);
    log->routeFrom = strdup(routeFrom);
    log->routeTo = strdup(routeTo);
    log->vfrNight = vfrNight;
    log->totalDurationMinutes = totalDurationMinutes;

    return log;
}

bool _in(int val, int start, int end)
{
    return val >= start && val <= end;
}

// Source: CLDR
// https://unicode-org.github.io/cldr-staging/charts/37/supplemental/language_plural_rules.html
char* _polish_plural(int count, char* one, char* few, char* many)
{
    if (count == 1) {
        return one;
    } else if (_in(count % 10, 2, 4) && !_in(count % 100, 12, 14)) {
        return few;
    } else {
        return many;
    }
}

void log_print(Log* log)
{
    char* night;
    if (log->vfrNight) {
        night = " w VFR NIGHT";
    } else {
        night = "";
    }

    char* minutesPlural = _polish_plural(log->totalDurationMinutes,
        "minutę", "minuty", "minut");

    printf("Samolot %s leciał z %s do %s%s przez %d %s.\n",
        log->aircraftIdent, log->routeFrom, log->routeTo,
        night, log->totalDurationMinutes, minutesPlural);
}