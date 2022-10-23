import model.Gender;
import repository.CsvFilesNameRepository;
import repository.InMemoryNameRepository;
import repository.NameRepository;
import repository.sort.AlphabeticalSort;
import repository.sort.OccurrencesSort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final NameRepository nameRepository = promptNameRepository(scanner);
        final NameRepository.SortStrategy sortStrategy = promptSortStrategy(scanner);

        assert nameRepository != null;
        nameRepository.setSortStrategy(sortStrategy);

        actionLoop(scanner, nameRepository);
    }

    private static NameRepository promptNameRepository(Scanner scanner) {
        while (true) {
            System.out.println("Wybierz repozytorium imion:");
            System.out.println("\t1 - Z pamięci (niewiele wyników)");
            System.out.println("\t2 - Z plików CSV (Kancelaria Prezesa Rady Ministrów, 2021, otwarte dane)");
            System.out.print("Twój wybór: ");

            try {
                final int number = scanner.nextInt();
                scanner.nextLine();

                switch (number) {
                    case 1:
                        return new InMemoryNameRepository();
                    case 2:
                        return new CsvFilesNameRepository(new String[]{
                                "data/imiona_meskie_2021.csv",
                                "data/imiona_zenskie_2021.csv"
                        });
                    default:
                        System.out.println("Niepoprawna liczba. Spróbuj ponownie\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.\n");
            } catch (Exception e) {
                System.out.println("Nieznany błąd. Spróbuj ponownie.\n");
            }
        }
    }

    private static NameRepository.SortStrategy promptSortStrategy(Scanner scanner) {
        while (true) {
            System.out.println("Wybierz strategię sortowania wyników:");
            System.out.println("\t1 - Alfabetycznie po nazwie");
            System.out.println("\t2 - Na odwrót alfabetycznie po nazwie");
            System.out.println("\t3 - Po liczbie wystąpień rosnąco");
            System.out.println("\t4 - Po liczbie wystąpień malejąco");
            System.out.print("Twój wybór: ");

            try {
                final int number = scanner.nextInt();
                scanner.nextLine();

                switch (number) {
                    case 1:
                        return new AlphabeticalSort();
                    case 2:
                        return new AlphabeticalSort(true);
                    case 3:
                        return new OccurrencesSort();
                    case 4:
                        return new OccurrencesSort(false);
                    default:
                        System.out.println("Niepoprawna liczba. Spróbuj ponownie\n");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.\n");
            } catch (Exception e) {
                System.out.println("Nieznany błąd. Spróbuj ponownie.\n");
            }
        }
    }

    private static void actionLoop(Scanner scanner, NameRepository nameRepository) {
        while (true) {
            System.out.println("Wybierz akcję do wykonania:");
            System.out.println("\t1 - Wypisz wszystkie imiona");
            System.out.println("\t2 - Wypisz wszystkie męskie imiona");
            System.out.println("\t3 - Wypisz wszystkie żeńskie imiona");
            System.out.println("\t4 - Wypisz wszystkie imiona rozpoczynające się na wybraną literę");
            System.out.println("\t5 - Zmień strategię sortowania");
            System.out.println("\t6 - Wyjdź");
            System.out.print("Twój wybór: ");

            try {
                final int number = scanner.nextInt();
                scanner.nextLine();

                switch (number) {
                    case 1 -> nameRepository
                            .getAll()
                            .forEach(name -> System.out.println(name.toString()));
                    case 2 -> nameRepository
                            .getByGender(Gender.male)
                            .forEach(name -> System.out.println(name.toString()));
                    case 3 -> nameRepository
                            .getByGender(Gender.female)
                            .forEach(name -> System.out.println(name.toString()));
                    case 4 -> {
                        final Character letter = promptLetter(scanner);
                        nameRepository
                                .getStartingWithLetter(letter)
                                .forEach(name -> System.out.println(name.toString()));
                    }
                    case 5 -> nameRepository.setSortStrategy(promptSortStrategy(scanner));
                    case 6 -> {
                        System.out.println("Cześć!");
                        return;
                    }
                    default -> System.out.println("Niepoprawna liczba. Spróbuj ponownie\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.\n");
            } catch (Exception e) {
                System.out.println("Nieznany błąd. Spróbuj ponownie.\n");
            }
        }
    }

    private static Character promptLetter(Scanner scanner) {
        while (true) {
            System.out.print("Podaj literę: ");

            final char[] chars = scanner.nextLine().toCharArray();
            if (chars.length != 1) {
                System.out.println("Niepoprawna pojedyncza litera. Spróbuj ponownie.\n");
            } else {
                return chars[0];
            }
        }
    }
}
