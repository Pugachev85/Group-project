package MenuActions;

import Entity.Person;
import Utils.PersonParser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FillFromFile implements MenuStrategy {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу (.txt или .csv): ");
        //  resources/demo.txt
        String path = scanner.nextLine();
        try {
            List<Person> persons = PersonParser.parse(path);
            System.out.println("Файл успешно загружен! Найдено " + persons.size() + " записей.");
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

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
