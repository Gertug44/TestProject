package org.example;

public enum Sex {
    MALE(true), FEMALE(false);
    boolean boolValue;
    Sex(boolean sex) {
        this.boolValue = sex;
    }

}
