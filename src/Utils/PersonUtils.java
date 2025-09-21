package Utils;

import Entity.Person;
import MenuActions.DataBase;

import java.util.Collection;

public class PersonUtils {

    public static void addPersonsToCollection(Collection<Person> persons) {
        if (UserDialog.askUser("Хотите добавить записи в коллекцию (д/н): ")) {
            DataBase.personCollection.addAll(persons);
            System.out.println("Записи добавлены!");
        } else {
            System.out.println("Вы отменили импорт данных!");
        }
    }
}
