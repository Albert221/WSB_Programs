package model;

public enum Gender {
    male("Mężczyzna"),
    female("Kobieta");

    final String name;

    Gender(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
