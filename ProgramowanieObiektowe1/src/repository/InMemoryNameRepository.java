package repository;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class InMemoryNameRepository extends BaseNameRepository{
    private final List<Name> names = new ArrayList<>();

    public InMemoryNameRepository() {
        super();
        populateNames();
    }

    public InMemoryNameRepository(SortStrategy sortStrategy) {
        super(sortStrategy);
        populateNames();
    }

    private void populateNames() {
        names.add(new Name("Andrzej", Gender.male, 10));
        names.add(new Name("Albert", Gender.male, 3));
        names.add(new Name("Aneta", Gender.female, 13));
        names.add(new Name("Anna", Gender.female, 35));
        names.add(new Name("Filip", Gender.male, 16));
        names.add(new Name("Małgorzata", Gender.female, 21));
    }

    @Override
    public List<Name> internalGetAll() {
        return names;
    }
}
