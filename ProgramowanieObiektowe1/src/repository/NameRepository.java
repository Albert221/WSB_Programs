package repository;

import model.*;

import java.util.Comparator;
import java.util.List;

public interface NameRepository {
    void setSortStrategy(SortStrategy strategy);

    List<Name> getAll();
    List<Name> getStartingWithLetter(Character letter);
    List<Name> getByGender(Gender gender);

    interface SortStrategy extends Comparator<Name> {}
}
