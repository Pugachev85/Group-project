package MenuActions;

import Entity.Person;
import Sorting.QuickSortEven;
import Sorting.SortAlgorithm;
import Utils.FileSaver;

import java.util.Comparator;

public class EvenSortStrategy implements MenuStrategy{
    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) {
            System.out.println("Коллекция пока пуста. Сначала заполните ее!");
            return;
        }

        Comparator<Person> comparator = Comparator.comparing(Person::getBirthYear);;

        SortAlgorithm<Person> sorter = new QuickSortEven<>(2);
        sorter.sort(DataBase.personCollection, comparator);

        System.out.println("Коллекция отсортирована! Результат:");
        DataBase.personCollection.forEach(System.out::println);

        FileSaver.saveCollection(DataBase.personCollection);

    }
}
