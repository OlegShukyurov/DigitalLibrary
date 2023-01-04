package ru.shukyurov.library.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.shukyurov.library.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        Book book = new Book();

        book.setBook_id(resultSet.getInt("book_id"));
        book.setPerson_id(resultSet.getInt("person_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthorName(resultSet.getString("authorName"));
        book.setYearOfWriting(resultSet.getInt("yearOfWriting"));

        return book;
    }
}
