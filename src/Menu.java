import MenuActions.MenuStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Menu {
    private String title;
    private Map<Integer, MenuItem> items = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Menu(String title) {
        this.title = title;
    }

    public void addItem(int key, String description, MenuStrategy strategy) {
        items.put(key, new MenuItem(description, strategy));
    }

    public void addSubMenuItem(int key, String description, Menu subMenu) {
        items.put(key, new MenuItem(description, subMenu::show));
    }

    public void show() {
        while (true) {
            System.out.println("\n" + title);
            for (Map.Entry<Integer, MenuItem> entry : items.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getDescription());
            }
            System.out.print("Выберите пункт: ");
            int choice = scanner.nextInt();
            if (items.containsKey(choice)) {
                items.get(choice).execute();
            } else {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}