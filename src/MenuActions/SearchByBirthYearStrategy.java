package MenuActions;

import Entity.Person;
import Utils.BinarySearch;
import java.util.Comparator;
import java.util.List;
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
        scanner.nextLine();
        
        Person searchKey = new Person.Builder().name("").surname("").birthYear(year).build();
        List<Integer> indexes = BinarySearch.binarySearchAll(DataBase.personCollection, searchKey, 
                                            Comparator.comparingInt(Person::getBirthYear));
        
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