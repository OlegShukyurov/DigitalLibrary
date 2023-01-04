package ru.shukyurov.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.shukyurov.library.models.Book;
import ru.shukyurov.library.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getPeople() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void addPerson(Person person) {
        jdbcTemplate.update("INSERT INTO Person(fullName, yearOfBirthday) VALUES (?,?)",
                person.getFullName(), person.getYearOfBirthday());
    }

    public Person getPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public List<Book> getPersonListOfBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }

    public void updatePerson(Person person, int id) {
        jdbcTemplate.update("UPDATE Person SET fullName=?, yearOfBirthday=? WHERE person_id=?",
                person.getFullName(), person.getYearOfBirthday(), id);
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE person_id=?", id);
    }
}
