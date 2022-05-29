#include "log.h"
#include "logbook.h"
#include <stdio.h>

void _new_log(LogBook* logbook);

int main()
{
    printf("Witaj w LogBooku na zaliczenie Podstaw Programowania!\n");

    LogBook* logbook = new_logbook();

    char command[2];
    while (1) {
        printf("\n=====\nKomendy: n - dodaj Nowy wpis, u - Usuń ostatni wpis, d - Drukuj wszystkie wpisy, w - Wyjdź\n");

        printf("Komenda: ");
        scanf(" %1s", command);

        switch (command[0]) {
        case 'w':
            return 0;
        case 'n':
            _new_log(logbook);
            break;
        case 'u':
            logbook_remove_last(logbook);
            printf("Usunięto ostatni wpis w logbooku.\n");
            break;
        case 'd':
            logbook_for_each(logbook, &log_print);
            break;
        default:
            printf("Niezrozumiała komenda.\n");
            break;
        }
    }
}

void _new_log(LogBook* logbook)
{
    char ident[7];
    printf("Podaj numer rejestracyjny samolotu (6 znaków): ");
    scanf("%6s", ident);

    char from[5];
    printf("Podaj lotnisku startu (ICAO): ");
    scanf("%4s", from);

    char to[5];
    printf("Podaj lotnisko lądowania (ICAO): ");
    scanf("%4s", to);

    bool vfrNight;
    while (1) {
        char night;
        printf("Czy lot był w nocy [t/n]: ");
        scanf(" %c", &night);

        if (night == 't') {
            vfrNight = true;
            break;
        } else if (night == 'n') {
            vfrNight = false;
            break;
        } else {
            printf("Niezrozumiała litera. Spróbuj ponownie.\n");
        }
    }

    int duration;
    printf("Podaj długość lotu (w minutach): ");
    scanf(" %d", &duration);

    Log* log = new_log(ident, from, to, vfrNight, duration);
    logbook_add(logbook, log);

    printf("Pomyślnie dodano wpis do logbooka!\n");
}

