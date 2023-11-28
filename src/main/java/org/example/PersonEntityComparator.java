package org.example;

import java.util.Comparator;

public class PersonEntityComparator implements Comparator<PersonEntity> {
    @Override
    public int compare(PersonEntity u1, PersonEntity u2) {
        return u1.compareTo(u2);
    }
}