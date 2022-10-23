package repository.sort;

import model.Name;
import repository.NameRepository;

public class NoSort implements NameRepository.SortStrategy {
    @Override
    public int compare(Name o1, Name o2) {
        return 0;
    }
}
