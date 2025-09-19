package MenuActions;

import Entity.Person;
import Utils.PersonParser;
import Utils.PersonUtils;
import Utils.UserDialog;

import java.util.ArrayList;

public class FillByUser implements MenuStrategy {
    @Override
    public void execute() {
        ArrayList<Person> persons = new ArrayList<>();
        while (true) {
            String line = UserDialog.askLine("Введите строку в формате \"Имя,Фамилия,Год рождния(цифрами)\": ");
            Person person;
            if (line.equals("Exit")) break;
            else person = PersonParser.parseLine(line);
            if (person != null) persons.add(person);
        }
        persons.stream()
                .map(Person::toString)
                .forEach(System.out::println);

        PersonUtils.addPersonsToCollection(persons);
    }
}
