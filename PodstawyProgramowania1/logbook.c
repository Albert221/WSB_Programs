#include "logbook.h"
#include "log.h"
#include <stdlib.h>

LogBook* new_logbook()
{
    LogBook* head = malloc(sizeof(LogBook));
    head->log = NULL;
    head->next = NULL;

    return head;
}

LogBook* _logbook_find_tail(LogBook* logbook)
{
    LogBook* cur = logbook;
    while (cur->next != NULL) {
        cur = cur->next;
    }

    return cur;
}

void logbook_add(LogBook* logbook, Log* log)
{
    if (logbook->log == NULL) {
        // If the logbook was empty, add it as a first item.
        logbook->log = log;
        return;
    }

    LogBook* tail = _logbook_find_tail(logbook);

    tail->next = malloc(sizeof(LogBook));
    tail->next->log = log;
    tail->next->next = NULL;
}

void logbook_remove_last(LogBook* logbook)
{
    if (logbook->next == NULL) {
        free(logbook->log);
        logbook->log = NULL;
        return;
    }

    LogBook* current = logbook;
    while (current->next->next != NULL) {
        current = current->next;
    }

    free(current->next);
    current->next = NULL;
}

void logbook_for_each(LogBook* logbook, void (*callback)(Log*))
{
    if (logbook->log == NULL)
        return;

    LogBook* current = logbook;
    do {
        callback(current->log);
        current = current->next;
    } while (current != NULL);
}

int logbook_count(LogBook* logbook)
{
    if (logbook->log == NULL)
        return 0;

    int count = 0;
    LogBook* current = logbook;
    do {
        count++;
        current = current->next;
    } while (current != NULL);

    return count;
}