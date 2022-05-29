![](photo.jpg)

# Podstawy Programowania 1

## Zaliczenie

Jest to prosty program służący jako bardzo prosty [logbook lotniczy](https://en.wikipedia.org/wiki/Pilot_logbook). Program pozwala na:

* Dodawanie nowych logów do logbooka, składających sie z:
  * [Numeru rejestracyjnego samolotu](https://pl.wikipedia.org/wiki/Mi%C4%99dzynarodowy_kod_samolotowy), np. SP-SPA
  * [Kodu ICAO lotniska](https://pl.wikipedia.org/wiki/Kod_lotniska_ICAO) startu, np. EPWA dla Warszawy Okęcie
  * Kodu ICAO lotniska lądowania, np. EPWR dla Wrocławia
  * Czy lot był w [VFR NIGHT](https://pl.wikipedia.org/wiki/Night_VFR)
  * Długości lotu w minutach
* Drukowanie na ekranie dodanych wpisów
  * Zlokalizowana liczba minut, zgodnie z wytycznymi dla lokalizacji polskich liczebników z [Common Locale Data Repository](https://cldr.unicode.org/)
* Usunięcie ostatniego wpisu z logbooka
* Wyjście z programu

Przechowywanie danych odbywa się w pamięci, dlatego po każdym otwarciu programu rozpoczynamy z pustym logbookiem.

Do przechowywania danych została zastosowana struktura danych _lista połączona_.

### Struktura programu

Program składa się z kilku plików:

* `main.c` - plik źródłowy C, wejściowy dla programu. Tutaj jest główna pętla programu, odczytywanie komend oraz wczytywanie wejścia od użytkownika
* `logbook.h` - plik nagłówkowy C ze strukturą logbooka oraz jego metodami
* `logbook.c` - plik źródłowy C zawierający implementację metod logbooka
* `log.h` - plik nagłówkowy C ze strukturą pojedynczego loga oraz jego metodami
* `log.c` - plik źródłowy C zawierający implementację metod pojedynczego logu.

### Demo programu

[![asciicast](https://asciinema.org/a/xdV15S7WILeU5PXE7zSzdPEX2.svg)](https://asciinema.org/a/xdV15S7WILeU5PXE7zSzdPEX2)

---

Header photo by [Trac Vu](https://unsplash.com/@tracminhvu?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText) on [Unsplash](https://unsplash.com/s/photos/cessna?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText)