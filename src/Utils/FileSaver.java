package Utils;

import Entity.Person;
import MenuActions.DataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class FileSaver {

    private static Scanner scanner = new Scanner(System.in);

    public static <T> void saveCollection(Collection<T> collection) {
        System.out.println("Хотите записать результат в файл (д/н): ");
        while (true) {
            String answer = scanner.nextLine();
            switch (answer) {
                case "д", "Д" -> {
                    System.out.print("Введите путь к файлу (.txt): ");
                    // resources/result.txt
                    String filePath = scanner.nextLine();
                    try (FileWriter writer = new FileWriter(filePath, true)){
                        for (Person person : DataBase.personCollection) {
                            writer.write(person.toString() + "\n");
                        }
                        writer.write("\n");
                        System.out.println("Результат сохранён в файл: " + filePath);
                    } catch (IOException e) {
                        System.out.println("Ошибка при записи в файл: " + e.getMessage());
                    }
                    return;
                }
                case "н", "Н" -> {
                    System.out.println("Вы отменили сохранение!");
                    return;
                }
                default -> System.out.println("Введите корректный ответ (д/н): ");
            }
        }
    }
}
