package MenuActions;

import Entity.Person;
import Utils.BinarySearch;
import java.util.Comparator;
import java.util.Scanner;

public class SearchByBirthYearStrategy implements MenuStrategy {
    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год рождения для поиска: ");
        int year = scanner.nextInt();
        
        Person searchKey = new Person.Builder().name("").surname("").birthYear(year).build();
        int index = BinarySearch.binarySearch(DataBase.personCollection, searchKey, 
                                            Comparator.comparingInt(Person::getBirthYear));
        
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