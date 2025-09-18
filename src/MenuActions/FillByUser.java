package MenuActions;

import Entity.Person;
import Utils.PersonParser;

import java.util.ArrayList;
import java.util.Scanner;

public class FillByUser implements MenuStrategy {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();
        while (true) {
            System.out.print("Введите строку в формате \"Имя,Фамилия,Год рождния(цифрами)\": ");
            String line = scanner.nextLine();
            Person person;
            if (line.equals("Exit")) break;
            else person = PersonParser.parseLine(line);
            if (person != null) persons.add(person);
        }
        persons.stream()
                .map(Person::toString)
                .forEach(System.out::println);
        System.out.println("Хотите добавить записи в коллекцию (д/н): ");
        while (true) {
            String answer = scanner.nextLine();
            switch (answer) {
                case "д", "Д" -> {
                    DataBase.personCollection.addAll(persons); //Переносим в основную коллекцию
                    System.out.println("Записи добавлены!");
                    return;
                }
                case "н", "Н" -> {
                    System.out.println("Вы отменили импорт данных!");
                    return;
                }
                default -> System.out.println("Введите корректный ответ (д/н): ");
            }
        }
    }
}
