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
        String path = scanner.nextLine();

        try {
            List<Person> persons = PersonParser.parse(path);
            System.out.println("Файл успешно загружен! Найдено " + persons.size() + " записей.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        }
    }
