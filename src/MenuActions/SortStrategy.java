package MenuActions;

import Entity.Person;
import Sorting.QuickSort;
import Sorting.SortAlgorithm;

import java.util.Comparator;

public class SortStrategy implements MenuStrategy {
    private final Field sortField;

    public SortStrategy(Field sortField) {
        this.sortField = sortField;
    }

    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) System.out.println("Коллекция пока пуста. Сначала заполните ее!");

        Comparator<Person> comparator;

        switch (sortField) {
            case NAME -> comparator = Comparator.comparing(Person::getName);
            case SURNAME -> comparator = Comparator.comparing(Person::getSurname);
            case BIRTHYEAR -> comparator = Comparator.comparing(Person::getBirthYear);
            default -> comparator = Comparator.comparing(Person::getBirthYear);
        }

        SortAlgorithm<Person> sorter = new QuickSort<>(2);
        sorter.sort(DataBase.personCollection, comparator);

        System.out.println("Коллекция отсортирована! Результат:");
        DataBase.personCollection.forEach(System.out::println);
    }
}
