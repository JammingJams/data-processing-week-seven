package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Program {

    public static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
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

        people.add(mara);
        people.add(theo);
        people.add(priya);
        people.add(ingrid);
        people.add(callum);
        people.add(darius);
        people.add(simone);
        people.add(fletcher);
        people.add(emre);
        people.add(nadia);

        //Collections.addAll(people, mara, theo);

        System.out.print("Search for first or last name: ");
        String userChoice = sc.nextLine().trim();

        boolean userMatchFound = false;

        for (Person p : people) {
            if ( (userChoice.equalsIgnoreCase(p.getFirstName()) || userChoice.equalsIgnoreCase(p.getLastName() ))) {
                System.out.println(p);
                userMatchFound = true;
            }
        }
        if (!userMatchFound) {
            System.out.println("No match found");
        }

        int sum = 0;

        for (Person p : people) {
            sum += p.getAge();
        }
        System.out.println("The sum age of the people is: " + sum);

        int oldestOrYoungestPerson = -1;

        for (Person p : people) {
            if (oldestOrYoungestPerson < p.getAge()) {
                oldestOrYoungestPerson = p.getAge();
            }
        }

        System.out.println("The oldest person is: " + oldestOrYoungestPerson);

        oldestOrYoungestPerson = 999;

        for (Person p : people) {
            if (oldestOrYoungestPerson > p.getAge()) {
                oldestOrYoungestPerson = p.getAge();
            }
        }

        System.out.println("The youngest person is: " + oldestOrYoungestPerson);
        

    }
}
