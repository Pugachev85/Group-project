package MenuActions;

import Entity.Person;
import Utils.BinarySearch;

import java.util.Comparator;
import java.util.Scanner;

public class SearchStrategy implements MenuStrategy {
    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) {
            System.out.println("Коллекция пуста. Сначала заполнии и отсортируйте её!");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите поле для поиска:");
        System.out.println("1. По имени");
        System.out.println("2. По фамилии"); 
        System.out.println("3. По году рожденияю");
        System.out.print("Ваш выбор: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Comparator<Person> comparator = null;
        String fieldName = "";
        
        switch (choice) {
            case 1:
                comparator = Comparator.comparing(Person::getName);
                fieldName = "имени";
                break;
            case 2:
                comparator = Comparator.comparing(Person::getSurname);
                fieldName = "фамилии";
                break;
            case 3:
                comparator = Comparator.comparingInt(Person::getBirthYear);
                fieldName = "году рождения";
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }
        
        System.out.print("Введите значение для поиска по " + fieldName + ": ");
        String searchValue = scanner.nextLine();
        
        Person searchKey = createSearchKey(choice, searchValue);
        
        int index = BinarySearch.binarySearch(DataBase.personCollection, searchKey, comparator);
        
        if (index >= 0) {
            System.out.println("Найден элемент: " + DataBase.personCollection.get(index));
        } else {
            System.out.println("Элемент не найдеен!");
        }
    }
    
    private Person createSearchKey(int choice, String value) {
        return switch (choice) {
            case 1 -> new Person.Builder().name(value).surname("").birthYear(0).build();
            case 2 -> new Person.Builder().name("").surname(value).birthYear(0).build();
            case 3 -> new Person.Builder().name("").surname("").birthYear(Integer.parseInt(value)).build();
            default -> throw new IllegalArgumentException("Неверный выбор поля");
        };
    }
}