package org.example.entityScheme;

import org.example.entityScheme.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{
    @Override
    public int compare(Person u1, Person u2) {
        return u1.compareTo(u2);
    }

}