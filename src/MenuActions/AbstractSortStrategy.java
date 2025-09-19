package MenuActions;

import Entity.Person;
import Sorting.SortAlgorithm;
import Utils.FileSaver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractSortStrategy implements MenuStrategy{

    public abstract Comparator<Person> comparator();
    public abstract SortAlgorithm<Person> sorter();

    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) {
            System.out.println("Коллекция пока пуста. Сначала заполните ее!");
            return;
        }

        SortAlgorithm<Person> sorter = sorter();

        // создаём копию коллекции, чтобы каждый раз начинать сортировку исходных данных
        List<Person> sortedCopy = new ArrayList<>(DataBase.personCollection);
        sorter.sort(sortedCopy, comparator());

        System.out.println("Коллекция отсортирована! Результат:");
        sortedCopy.forEach(System.out::println);

        FileSaver.saveCollection(sortedCopy);

    }
}
