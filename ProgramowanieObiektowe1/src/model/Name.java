package model;

public record Name(String name, Gender gender, Integer occurrences) {
    @Override
    public String toString() {
        return String.format("%s (płeć = %s, %s)", name, gender, occurrencesToString());
    }

    private String occurrencesToString() {
        // https://unicode-org.github.io/cldr-staging/charts/latest/supplemental/language_plural_rules.html#pl
        String occurrencesWord;
        if (occurrences == 1) {
            occurrencesWord = "wystąpienie";
        } else if (occurrences % 10 >= 2 && occurrences % 10 <= 4 &&
                !(occurrences % 100 >= 12 && occurrences % 100 <= 14)) {
            occurrencesWord = "wystąpienia";
        } else {
            occurrencesWord = "wystąpień";
        }

        return String.format("%d %s", occurrences, occurrencesWord);
    }
}
