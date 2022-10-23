package repository.sort;

import model.Name;
import repository.NameRepository;

public class OccurrencesSort implements NameRepository.SortStrategy {
    private final Boolean ascending;

    public OccurrencesSort() {
        this.ascending = true;
    }

    public OccurrencesSort(Boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Name a, Name b) {
        final int compared = a.occurrences().compareTo(b.occurrences());
        if (ascending) {
            return compared;
        } else {
            return -compared;
        }
    }
}
