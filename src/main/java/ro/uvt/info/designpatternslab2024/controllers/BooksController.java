package ro.uvt.info.designpatternslab2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2024.models.Book;
import ro.uvt.info.designpatternslab2024.services.BooksService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        booksService.addBook(book);
        booksService.getAllBooksSubject().notifyObservers(book);
        System.out.println("book added");
        return ResponseEntity.ok("Book created: " + book.getTitle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Optional<Book> book = booksService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        booksService.updateBook(id, updatedBook);
        return ResponseEntity.ok("Book updated: " + updatedBook.getTitle());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        booksService.deleteBook(id);
        return ResponseEntity.ok("Book deleted with ID: " + id);
    }
}
