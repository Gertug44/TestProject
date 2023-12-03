package org.example;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person u1, Person u2) {
        return u1.compareTo(u2);
    }
}