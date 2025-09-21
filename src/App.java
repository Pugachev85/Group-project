import MenuActions.*;

public class App {
    public static void main(String[] args) {
        Menu fillSubMenu = new Menu("Заполнение коллекции\n");
        Menu sortSubMenu = new Menu("Сортировка коллекции\n");
        Menu searchSubMenu = new Menu("Поиск в коллекции\n");
        Menu mainMenu = new Menu("Главное меню\n");

        fillSubMenu.addItem("1", "Заполнить коллекцию из файла", new FillFromFile());
        fillSubMenu.addItem("2", "Заполнить коллекцию случайными данными", new FillRandom());
        fillSubMenu.addItem("3", "Ввести вручную", new FillByUser());
        fillSubMenu.addSubMenuItem("4", "Назад", mainMenu);

        sortSubMenu.addItem("1", "Сортировать по имени", new SortStrategy(Field.NAME));
        sortSubMenu.addItem("2", "Сортировать по фамилии", new SortStrategy(Field.SURNAME));
        sortSubMenu.addItem("3", "Сортировать по году рождния", new SortStrategy(Field.BIRTHYEAR));
        sortSubMenu.addItem("4", "Доп. Задание №1", new EvenSortStrategy());
        sortSubMenu.addSubMenuItem("5", "Назад", mainMenu);

        searchSubMenu.addItem("1", "Поиск по имени", new SearchByNameStrategy());
        searchSubMenu.addItem("2", "Поиск по фамилии", new SearchBySurnameStrategy());
        searchSubMenu.addItem("3", "Поиск по году рождения", new SearchByBirthYearStrategy());
        searchSubMenu.addItem("4", "Доп. Задание №4", new CountOfEntriesStrategy());
        searchSubMenu.addSubMenuItem("5", "Назад", mainMenu);
      
        mainMenu.addSubMenuItem("1", "Заполнение исходной коллекции", fillSubMenu);
        mainMenu.addSubMenuItem("2", "Отсортировать коллекцию", sortSubMenu);
        mainMenu.addSubMenuItem("3", "Поиск", searchSubMenu);
        mainMenu.addItem("4", "Вывести коллекцию на экран", new PrintCollectionStrategy());
        mainMenu.addItem("5", "Выход", new ExitStrategy());

        // Запуск главного меню
        mainMenu.show();
    }
}