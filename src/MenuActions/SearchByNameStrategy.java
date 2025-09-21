package MenuActions;

import Entity.Person;
import Utils.BinarySearch;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SearchByNameStrategy implements MenuStrategy {
    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        
        Person searchKey = new Person.Builder().name(name).surname("").birthYear(0).build();
        List<Integer> indexes = BinarySearch.binarySearchAll(DataBase.personCollection, searchKey, 
                                            Comparator.comparing(Person::getName));
        
        printSearchResults(indexes);
    }
    
    private void printSearchResults(List<Integer> indexes) {
        if (indexes.isEmpty()) {
            System.out.println("Ничего не найдено!");
        } else {
            System.out.println("Найдено " + indexes.size() + " записей:");
            for (int index : indexes) {
                System.out.println(DataBase.personCollection.get(index));
            }
        }
    }
}