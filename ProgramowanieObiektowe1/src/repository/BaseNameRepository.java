package repository;

import model.Gender;
import model.Name;
import repository.sort.NoSort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class BaseNameRepository implements NameRepository {
    private SortStrategy sortStrategy;

    public BaseNameRepository() {
        this.sortStrategy = new NoSort();
    }

    public BaseNameRepository(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    @Override
    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    abstract public List<Name> internalGetAll();

    private Stream<Name> getAllStream() {
        return internalGetAll().stream().sorted(sortStrategy);
    }

    @Override
    final public List<Name> getAll() {
        return getAllStream().collect(Collectors.toList());
    }

    @Override
    final public List<Name> getByGender(Gender gender) {
        return getAllStream()
                .filter(name -> name.gender() == gender)
                .collect(Collectors.toList());
    }

    @Override
    final public List<Name> getStartingWithLetter(Character letter) {
        return getAllStream()
                .filter(name -> name.name().startsWith(letter.toString()))
                .collect(Collectors.toList());
    }
}
