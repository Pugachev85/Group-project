package MenuActions;

import Entity.Person;
import CustomCollections.CustomPersonCollection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FillRandom implements MenuStrategy {

    private static final List<String> randomNames = List.of(
        "Ivan", "Alexey", "Olga", "Dmitry", "Anna",
        "Pavel", "Marina", "Sergey", "Nikolay", "Elena"
    );

    private static final List<String> randomSurnames = List.of(
        "Ivanov", "Petrov", "Sidorov", "Volkov", "Smirnov",
        "Kuznetsov", "Popov", "Vasiliev", "Mikhailov", "Fedorov"
    );

    private static final int MIN_BIRTH_YEAR = 1950;
    private static final int MAX_BIRTH_YEAR = 2010;

    private final Random random = new Random();

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество объектов для рандомного заполнения: ");

        int count;
        try {
            count = Integer.parseInt(scanner.nextLine());
            if (count <= 0) {
                System.out.println("Количество должно быть положительным числом.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Ожидалось число.");
            return;
        }

        List<Person> randomPersons = IntStream.range(0, count)
            .mapToObj(i -> new Person.Builder()
                .name(randomNames.get(random.nextInt(randomNames.size())))
                .surname(randomSurnames.get(random.nextInt(randomSurnames.size())))
                .birthYear(random.nextInt(MAX_BIRTH_YEAR - MIN_BIRTH_YEAR + 1) + MIN_BIRTH_YEAR)
                .build())
            .collect(Collectors.toList());

        System.out.println("Сгенерированные случайные объекты:");
        randomPersons.forEach(System.out::println);

        CustomPersonCollection customCollection = randomPersons.stream()
            .collect(Collectors.toCollection(CustomPersonCollection::new));

        DataBase.personCollection.addAll(customCollection);

        System.out.println("Объекты успешно добавлены в коллекцию!");
    }
}