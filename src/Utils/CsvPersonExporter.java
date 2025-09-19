package Utils;

import Entity.Person;

public class CsvPersonExporter implements PersonExporter {
    @Override
    public String export(Person person) {
        return person.getName() + "," + person.getSurname() + "," + person.getBirthYear();
    }
}
