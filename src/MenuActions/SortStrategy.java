package MenuActions;

import Entity.Person;
import Sorting.QuickSort;
import Sorting.SortAlgorithm;
import java.util.Comparator;

public class SortStrategy extends AbstractSortStrategy {
    private final Field sortField;

    public SortStrategy(Field sortField) {
        this.sortField = sortField;
    }

    @Override
    public Comparator<Person> comparator() {
        return switch (sortField) {
            case NAME -> Comparator.comparing(Person::getName);
            case SURNAME -> Comparator.comparing(Person::getSurname);
            case BIRTHYEAR -> Comparator.comparing(Person::getBirthYear);
            default -> Comparator.comparing(Person::getBirthYear);
        };
    }

    @Override
    public SortAlgorithm<Person> sorter() {
        return new QuickSort<>(2);
    }
}
