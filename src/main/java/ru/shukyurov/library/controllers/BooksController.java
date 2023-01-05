package ru.shukyurov.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shukyurov.library.dao.BookDAO;
import ru.shukyurov.library.dao.PersonDAO;
import ru.shukyurov.library.models.Book;
import ru.shukyurov.library.models.Person;


@Controller
@RequestMapping("/books")
public class BooksController {

    private final PersonDAO personDAO;
    private final BookDAO bookDAO;

    @Autowired
    public BooksController(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public String showBooks(Model model) {
        model.addAttribute("books", bookDAO.getBooks());

        return "books/showBooks";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {

        return "books/new";
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") Book book) {
        bookDAO.addBook(book);

        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("book", bookDAO.getBook(id));
        model.addAttribute("people", personDAO.getPeople());

        return "books/showBook";
    }

    @PatchMapping("/selectOwner{id}")
    public String selectOwner(@ModelAttribute Person person, @PathVariable("id") int id) {
        bookDAO.makeOwner(person.getPerson_id(), id);

        return "redirect:/books/{id}";
    }

    @DeleteMapping("/releaseOwner{id}")
    public String releaseOwner(@PathVariable("id") int id) {
        bookDAO.deleteOwner(id);

        return "redirect:/books/{id}";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getBook(id));

        return "books/editBook";
    }

    @PatchMapping("/{id}")
    public String updateBook(@PathVariable("id") int id, @ModelAttribute("book") Book book) {
        bookDAO.updateBook(id, book);

        return "redirect:/books";
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookDAO.deleteBook(id);

        return "redirect:/books";
    }
}
