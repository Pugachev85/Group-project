package Entity;

import java.util.Comparator;

public class Person {
    private final String name;
    private final String surname;
    private final int birthYear;

    private Person(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthYear = builder.birthYear;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public static class Builder {
        private String name;
        private String surname;
        private int birthYear;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder birthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public static Comparator<Person> compareByAllFields() {
        return (p1, p2) -> {
            int surnameCompare = p1.getSurname().compareTo(p2.getSurname());
            if (surnameCompare != 0) {
                return surnameCompare;
            }
            int nameCompare = p1.getName().compareTo(p2.getName());
            if (nameCompare != 0) {
                return nameCompare;
            }
            return Integer.compare(p1.getBirthYear(), p2.getBirthYear());
        };
    }
}
