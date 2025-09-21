package Utils;

import Entity.Person;
import MenuActions.DataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class FileSaver {

    public static <T> void saveCollection(Collection<T> collection) {
        if (UserDialog.askUser("Хотите записать результат в файл (д/н): ")) {
            String filePath = UserDialog.askFilePath("Введите путь к файлу (.txt): ");
            PersonExporter exporter = new CsvPersonExporter();

            try (FileWriter writer = new FileWriter(filePath, true)) {
                for (Person person : DataBase.personCollection) {
                    writer.write(exporter.export(person) + "\n");
                }
                writer.write("\n");
                System.out.println("Результат сохранён в файл: " + filePath);
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }
        } else {
            System.out.println("Вы отменили сохранение!");
        }
    }
}