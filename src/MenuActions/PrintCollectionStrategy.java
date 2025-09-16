package MenuActions;

import Entity.Person;

public class PrintCollectionStrategy implements MenuStrategy {
    @Override
    public void execute() {
        if (DataBase.personCollection.isEmpty()) System.out.println("Коллекция пока пуста. Сначала заполните ее!");
        else DataBase.personCollection.stream().map(Person::toString).forEach(System.out::println);
    }
}
