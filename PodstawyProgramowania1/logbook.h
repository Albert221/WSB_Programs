#ifndef _logbook_h
#define _logbook_h

#include "log.h"

typedef struct LogBook {
    Log* log;
    struct LogBook* next;
} LogBook;

LogBook* new_logbook();

void logbook_add(LogBook* logbook, Log* log);

void logbook_remove_last(LogBook* logbook);

void logbook_for_each(LogBook* logbook, void (*callback)(Log*));

int logbook_count(LogBook* logbook);

#endif