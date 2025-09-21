package MenuActions;

import Entity.Person;
import Utils.BinarySearch;
import java.util.Comparator;
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
        int index = BinarySearch.binarySearch(DataBase.personCollection, searchKey, 
                                            Comparator.comparing(Person::getName));
        
        printSearchResult(index);
    }
    
    private void printSearchResult(int index) {
        if (index >= 0) {
            System.out.println("Найден: " + DataBase.personCollection.get(index));
        } else {
            System.out.println("Не найдено!");
        }
    }
}