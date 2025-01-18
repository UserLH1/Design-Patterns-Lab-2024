package ro.uvt.info.designpatternslab2024.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2024.models.Book;
import ro.uvt.info.designpatternslab2024.persistence.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public void addBook(Book book) {
        booksRepository.save(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    public void updateBook(Long id, Book updatedBook) {
        Optional<Book> existingBook = booksRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthors(updatedBook.getAuthors());
            book.setElements(updatedBook.getElements());
            booksRepository.save(book);
            System.out.println("Book updated: " + book.getTitle());
        } else {
            System.out.println("Invalid book ID");
        }
    }

    public void deleteBook(Long id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            System.out.println("Book deleted with ID: " + id);
        } else {
            System.out.println("Invalid book ID");
        }
    }
}
