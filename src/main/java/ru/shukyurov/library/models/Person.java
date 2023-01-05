package ru.shukyurov.library.models;

import javax.validation.constraints.*;

public class Person {

    private int person_id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 12, max = 100, message = "Name should be between 12 and 100 characters")
    @Pattern(regexp = "^([А-Я][а-я]*\\s[А-Я][а-я]*\\s[А-Я][а-я]*)$",
    message = "Your name should be in this format: 'Surname' 'Name' 'Lastname' for example: 'Иванов Иван Иванович'")
    private String fullName;

    @Min(value = 1900, message = "Year should be greater than 1900")
    @Max(value = 2023, message = "Year should be 2023 or smaller")
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
