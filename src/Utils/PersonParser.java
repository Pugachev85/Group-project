package Utils;

import Entity.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonParser {

    public static List<Person> parseFile(String path) throws IOException {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Person person = parseLine(line);
                if (person != null) persons.add(person);
            }
        }
        return persons;
    }

    public static Person parseLine(String line) {
        String[] fields = line.split(",");
        if (fields.length != 3) {
            System.out.println("Не верный формат строки.");
            return null;
        }
        String name = fields[0].trim();
        String surname = fields[1].trim();
        int year = Integer.parseInt(fields[2].trim());

        return new Person.Builder()
                .name(name)
                .surname(surname)
                .birthYear(year)
                .build();
    }

    public static List<Person> parseFileByStream(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.lines()
                    .map(PersonParser::parseLine)
                    .filter(Objects::nonNull)
                    .toList();
        }
    }
}
