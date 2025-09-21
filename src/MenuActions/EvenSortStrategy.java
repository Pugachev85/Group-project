package MenuActions;

import Entity.Person;
import Sorting.QuickSortEven;
import Sorting.SortAlgorithm;

import java.util.Comparator;

public class EvenSortStrategy extends AbstractSortStrategy{

    @Override
    public Comparator<Person> comparator() {
        return Comparator.comparing(Person::getBirthYear);
    }

    @Override
    public SortAlgorithm<Person> sorter() {
        return new QuickSortEven<>();
    }
}
