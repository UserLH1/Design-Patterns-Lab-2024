package ro.uvt.info.designpatternslab2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2024.commands.Command;
import ro.uvt.info.designpatternslab2024.commands.CreateBookCommand;
import ro.uvt.info.designpatternslab2024.commands.DeleteBookCommand;
import ro.uvt.info.designpatternslab2024.commands.UpdateBookCommand;
import ro.uvt.info.designpatternslab2024.models.Book;
import ro.uvt.info.designpatternslab2024.observer.Subject;
import ro.uvt.info.designpatternslab2024.services.BooksService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;
    private final Subject allBooksSubject; // Injectează subiectul pentru notificări

    @Autowired
    public BooksController(BooksService booksService, Subject allBooksSubject) {
        this.booksService = booksService;
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        Command createCommand = new CreateBookCommand(booksService, allBooksSubject, book);
        createCommand.execute(); // Execută comanda
        return ResponseEntity.ok("Book created: " + book.getTitle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Optional<Book> book = booksService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Command updateCommand = new UpdateBookCommand(booksService, allBooksSubject, id, updatedBook);
        updateCommand.execute(); // Execută comanda
        return ResponseEntity.ok("Book updated: " + updatedBook.getTitle());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        Command deleteCommand = new DeleteBookCommand(booksService, allBooksSubject, id);
        deleteCommand.execute(); // Execută comanda
        return ResponseEntity.ok("Book deleted with ID: " + id);
    }
}
