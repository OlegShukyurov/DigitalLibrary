package ru.shukyurov.library.models;

public class Person {

    private int person_id;
    private String fullName;
    private int yearOfBirthday;

    public Person() {
    }

    public Person(int person_id, String fullName, int yearOfBirthday) {
        this.person_id = person_id;
        this.fullName = fullName;
        this.yearOfBirthday = yearOfBirthday;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirthday() {
        return yearOfBirthday;
    }

    public void setYearOfBirthday(int yearOfBirthday) {
        this.yearOfBirthday = yearOfBirthday;
    }
}
