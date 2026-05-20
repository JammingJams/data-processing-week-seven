package com.pluralsight;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Program {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Person mara = new Person("Mara", "Ellison", 16);
        Person theo = new Person("Theo", "Nakamura", 24);
        Person priya = new Person("Priya", "Sandoval", 67);
        Person ingrid = new Person("Ingrid", "Vasquez", 23);
        Person callum = new Person("Callum", "Osei", 24);
        Person darius = new Person("Darius", "Wren", 90);
        Person simone = new Person("Simone", "Achebe", 24);
        Person fletcher = new Person("Fletcher", "Yıldız", 45);
        Person emre = new Person("Emre", "Callahan", 12);
        Person nadia = new Person("Nadia", "Kowalski", 89);

        ArrayList<Person> people = new ArrayList<>();


        Collections.addAll(people, mara, theo, priya, ingrid, callum, darius, simone, fletcher, emre, nadia);

        System.out.print("Search for first or last name: ");
        String userChoice = sc.nextLine().trim();

        getFirstAndLastName(people, userChoice);

        getAverageAge(people);

        getOldestPerson(people);
        getYoungestPerson(people);

    }

    public static ArrayList<Person> getFirstAndLastName(ArrayList<Person> people, String userChoice) {
        ArrayList<Person> result = people.stream().filter(p -> p.getFirstName().equalsIgnoreCase(userChoice) || p.getLastName().equalsIgnoreCase(userChoice)).collect(Collectors.toCollection(ArrayList::new));

        result.forEach(System.out::println);
        return result;
    }

    public static int getAverageAge(ArrayList<Person> people) {
        int result = (int) (people.stream().mapToInt(p -> p.getAge()).average().orElse(0));

        System.out.println("Average age is: " + result);
        return result;
    }

    public static int getOldestPerson(ArrayList<Person> people) {
        java.util.Optional<Person> result = people.stream().max(Comparator.comparing(Person::getAge));

        if (result != null) {
            System.out.println(result);
            return result.get().getAge();
        }
        System.out.println("List can't be found");
        return 0;
    }

    public static int getYoungestPerson(ArrayList<Person> people) {
        java.util.Optional<Person> result = people.stream().min(Comparator.comparing(Person::getAge));

        if (result != null) {
            System.out.println(result);
            return result.get().getAge();
        }
        System.out.println("List can't be found");
        return 0;
    }
}
