import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("\nДобро пожаловать в наше приложение!");
        Menu menu = new Menu.Builder()
                .addItem("Заполнние исходного массива")
                .addItem("Отсортировать массив")
                .addItem("Поиск")
                .addItem("Выход из программы").build();

        boolean isBreak = false;

        while (!isBreak) {
            menu.display();
            switch (getUserChoice()) {
                case "1" -> showSubMenuFill();
                case "2" -> showSubMenuSort();
                case "3" -> searchPersons();
                case "4" -> isBreak = true;
                default -> System.out.println("\nНеверный выбор. Попробуйте еще раз:");
            }

        }
    }

    public static String getUserChoice() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showSubMenuFill() {
        Menu subMenu = new Menu.Builder()
                .addItem("Заполнить коллекцию из файла")
                .addItem("Заполнить коллекцию случайными данными")
                .addItem("Ввести вручную")
                .addItem("Вернуться").build();

        while (true) {
            subMenu.display();
            switch (getUserChoice()) {
                case "1" -> System.out.println("1.1.");
                case "4" -> {
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте еще раз:");
            }
        }
    }

    private static void searchPersons() {}

    private static void showSubMenuSort() {
        Menu subMenu = new Menu.Builder()
                .addItem("Сортировать по имени")
                .addItem("Сортировать по фамилии")
                .addItem("Сортировать по году рождния")
                .addItem("Вернуться").build();

        while (true) {
            subMenu.display();
            switch (getUserChoice()) {
                case "1" -> System.out.println("1.1.");
                case "4" -> {
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте еще раз:");
            }
        }
    }
}