package org.example.entityScheme;

import org.example.entityScheme.Person;
import org.example.entityScheme.PersonEntity;

public class PersonsEquals {

    public static boolean isPersonsEqual(Person p1, Person p2){return p1.equals(p2);}
    public static boolean isPersonsEqual(PersonEntity p1, Person p2){
        return isPersonsEqual(p2, p1);
    }
    public static boolean isPersonsEqual(PersonEntity p1, PersonEntity p2){return p1.equals(p2);}
    public static boolean isPersonsEqual(Person p1, PersonEntity p2){
        return p1.getId() ==p2.getId() && p1.getAge() == p2.getAge()
                && p1.getFirstName().equals(p2.getFirstName()) && p1.getSecondName().equals(p2.getSecondName())
                && p1.isSex() == p2.isSex();
    }

}
