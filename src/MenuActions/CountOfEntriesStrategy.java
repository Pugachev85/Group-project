package MenuActions;

import java.util.Scanner;

public class CountOfEntriesStrategy implements MenuStrategy {
    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) {
            System.out.println("Коллекция пока пуста. Сначала заполните ее!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для подсчета чиста вхождений: ");
        String text = scanner.nextLine();
        int result = DataBase.personCollection.parallelStream()
                .filter(person -> person.getName().equals(text)
                        || person.getSurname().equals(text)
                        || String.valueOf(person.getBirthYear()).equals(text))
                .toList().size();
        System.out.printf("Число вхождений строки \"%s\" в коллекцию равно %d\n", text, result);
    }
}
