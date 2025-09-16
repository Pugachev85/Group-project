package Utils;

import Entity.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonParser {
    public static List<Person> parse(String path) throws IOException {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 3) continue;
                String name = fields[0].trim();
                String surname = fields[1].trim();
                int year = Integer.parseInt(fields[2].trim());

                Person person = new Person.Builder()
                        .name(name)
                        .surname(surname)
                        .birthYear(year)
                        .build();
                persons.add(person);
            }
        }
        return persons;
    }
}
