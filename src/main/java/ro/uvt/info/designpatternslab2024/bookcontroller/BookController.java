package ro.uvt.info.designpatternslab2024.bookcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2024.bookmodel.Book;
import ro.uvt.info.designpatternslab2024.bookservice.BookService;
import ro.uvt.info.designpatternslab2024.command.AddBookCommand;
import ro.uvt.info.designpatternslab2024.command.CommandExecutor;
import ro.uvt.info.designpatternslab2024.command.DeleteBookCommand;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final CommandExecutor commandExecutor;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        AddBookCommand command = new AddBookCommand(bookService, book);
        commandExecutor.execute(command, true); // Asynchronous
        return ResponseEntity.accepted().body("Book is being added...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        DeleteBookCommand command = new DeleteBookCommand(bookService, id);
        commandExecutor.execute(command, false); // Synchronous
        return ResponseEntity.ok("Book deleted successfully!");
    }
}
