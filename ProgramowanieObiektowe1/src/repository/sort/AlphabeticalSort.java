package repository.sort;

import model.Name;
import repository.NameRepository;

public class AlphabeticalSort implements NameRepository.SortStrategy {
    private final Boolean reverse;

    public AlphabeticalSort() {
        this.reverse = false;
    }

    public AlphabeticalSort(Boolean reverse) {
        this.reverse = reverse;
    }

    @Override
    public int compare(Name a, Name b) {
        final int compared = a.name().compareTo(b.name());
        if (reverse) {
            return -compared;
        } else {
            return compared;
        }
    }
}
