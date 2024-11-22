package ro.uvt.info.designpatternslab2024.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    private final List<String> books = new ArrayList<>();


    public List<String> getAllBooks() {
        return new ArrayList<>(books);
    }


    public void addBook(String bookName) {
        books.add(bookName);
        System.out.println("Book added: " + bookName);
    }


    public String getBookById(int id) {
        if (id >= 0 && id < books.size()) {
            return books.get(id);
        }
        return "Book not found";
    }


    public void updateBook(int id, String newBookName) {
        if (id >= 0 && id < books.size()) {
            books.set(id, newBookName);
            System.out.println("Book updated: " + newBookName);
        } else {
            System.out.println("Invalid book ID");
        }
    }


    public void deleteBook(int id) {
        if (id >= 0 && id < books.size()) {
            System.out.println("Book deleted: " + books.remove(id));
        } else {
            System.out.println("Invalid book ID");
        }
    }
}
