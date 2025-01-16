package ro.uvt.info.designpatternslab2024.chaincommand.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2024.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<String> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping
    public void createBook(@RequestBody String bookName) {
        booksService.addBook(bookName);
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable int id) {
        return booksService.getBookById(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody String newBookName) {
        booksService.updateBook(id, newBookName);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        booksService.deleteBook(id);
    }
}
