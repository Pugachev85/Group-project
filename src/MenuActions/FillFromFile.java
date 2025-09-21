package MenuActions;

import Entity.Person;
import Utils.PersonParser;
import Utils.PersonUtils;
import Utils.UserDialog;

import java.io.IOException;
import java.util.List;

public class FillFromFile implements MenuStrategy {

    @Override
    public void execute() {
        String path = UserDialog.askFilePath("Введите путь к файлу (.txt или .csv): ");
        //  resources/demo.txt
        try {
            List<Person> persons = PersonParser.parseFile(path);
            System.out.println("Файл успешно загружен! Найдено " + persons.size() + " записей.");
            persons.stream()
                    .map(Person::toString)
                    .forEach(System.out::println);
            PersonUtils.addPersonsToCollection(persons);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
