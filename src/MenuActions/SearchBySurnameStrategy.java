package MenuActions;

import Entity.Person;
import Utils.BinarySearch;
import java.util.Comparator;
import java.util.Scanner;

public class SearchBySurnameStrategy implements MenuStrategy {
    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите фамилию для поиска: ");
        String surname = scanner.nextLine();
        
        Person searchKey = new Person.Builder().name("").surname(surname).birthYear(0).build();
        int index = BinarySearch.binarySearch(DataBase.personCollection, searchKey, 
                                            Comparator.comparing(Person::getSurname));
        
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