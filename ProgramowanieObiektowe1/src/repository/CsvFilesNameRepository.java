package repository;

import model.Gender;
import model.Name;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CsvFilesNameRepository extends BaseNameRepository {
    private final List<Name> names = new ArrayList<>();

    public CsvFilesNameRepository(String[] csvFilePaths) throws FileNotFoundException {
        loadCSVs(csvFilePaths);
    }

    private void loadCSVs(String[] csvFilePaths) throws FileNotFoundException {
        for (String path : csvFilePaths) {
            final File file = new File(path);
            assert file.exists();

            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // Drop header line

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                if (line.isEmpty()) break;

                final Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");

                final String name = capitalize(lineScanner.next());
                final Gender gender = switch (lineScanner.next()) {
                    case "MĘŻCZYZNA" -> Gender.male;
                    case "KOBIETA" -> Gender.female;
                    default -> null;
                };
                assert gender != null;
                final int occurrences = lineScanner.nextInt();

                names.add(new Name(name, gender, occurrences));
            }
        }
    }

    private static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

    @Override
    public List<Name> internalGetAll() {
        return names;
    }
}
