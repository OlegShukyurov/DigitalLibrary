package ru.shukyurov.library.models;

public class Book {

    private int book_id;
    private int person_id;
    private String title;
    private String authorName;
    private int yearOfWriting;


    public Book(int book_id, int person_id, String title, String authorName, int yearOfWriting) {
        this.book_id = book_id;
        this.person_id = person_id;
        this.title = title;
        this.authorName = authorName;
        this.yearOfWriting = yearOfWriting;
    }

    public Book() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearOfWriting() {
        return yearOfWriting;
    }

    public void setYearOfWriting(int yearOfWriting) {
        this.yearOfWriting = yearOfWriting;
    }
}
