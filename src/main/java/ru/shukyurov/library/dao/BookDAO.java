package ru.shukyurov.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.shukyurov.library.models.Book;
import ru.shukyurov.library.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooks() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }

    public void addBook(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title, authorName, yearOfWriting) VALUES(?, ?, ?)",
                            book.getTitle(), book.getAuthorName(), book.getYearOfWriting());
    }

    public Book getBook(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id}, new BookMapper())
                                 .stream().findAny().orElse(null);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.person_id " +
                "WHERE Book.book_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void deleteOwner(int bookId) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", null, bookId);
    }

    public void makeOwner(int personId, int bookId) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", personId, bookId);
    }

    public void updateBook(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET title=?, authorName=?, yearOfWriting=? WHERE book_id=?",
                book.getTitle(), book.getAuthorName(), book.getYearOfWriting(), id);
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }
}
