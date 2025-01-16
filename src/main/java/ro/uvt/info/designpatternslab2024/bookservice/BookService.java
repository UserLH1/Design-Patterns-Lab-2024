package ro.uvt.info.designpatternslab2024.bookservice;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2024.bookmodel.Book;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookService {
    private final Map<Integer, Book> books = new ConcurrentHashMap<>();

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void updateBook(int id, Book updatedBook) {
        books.put(id, updatedBook);
    }

    public void deleteBook(int id) {
        books.remove(id);
    }
}
