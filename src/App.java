import MenuActions.*;

public class App {

    public static void main(String[] args) {

        Menu fillSubMenu = new Menu("Заполнение коллекции\n");
        Menu sortSubMenu = new Menu("Сортировка коллекции\n");
        Menu mainMenu = new Menu("Главное меню\n");

        fillSubMenu.addItem("1", "Заполнить коллекцию из файла", new FillFromFile());
        fillSubMenu.addItem("2", "Заполнить коллекцию случайными данными", new FillRandom());
        fillSubMenu.addItem("3", "Ввести вручную", new FillByUser());
        fillSubMenu.addSubMenuItem("4", "Назад", mainMenu);

        sortSubMenu.addItem("1", "Сортировать по имени", new SortStrategy());
        sortSubMenu.addItem("2", "Сортировать по фамилии", new SortStrategy());
        sortSubMenu.addItem("3", "Сортировать по году рождния", new SortStrategy());
        sortSubMenu.addSubMenuItem("4", "Назад", mainMenu);

        mainMenu.addSubMenuItem("1", "Заполнние исходной коллекции", fillSubMenu);
        mainMenu.addSubMenuItem("2", "Отсортировать коллекцию", sortSubMenu);
        mainMenu.addItem("3", "Поиск", new SearchStrategy());
        mainMenu.addItem("4", "Выход", new ExitStrategy());

        // Запуск главного меню
        mainMenu.show();
    }
}