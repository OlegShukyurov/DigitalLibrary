package ru.shukyurov.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.shukyurov.library.models.Book;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooks() {
        BeanPropertyRowMapper<Book> bprm = new BeanPropertyRowMapper<>(Book.class);
        
        bprm.setPrimitivesDefaultedForNullValue(true);
        return jdbcTemplate.query("SELECT * FROM Book", bprm);
    }
}
