package ro.uvt.info.designpatternslab2024.commands;

import ro.uvt.info.designpatternslab2024.models.Book;
import ro.uvt.info.designpatternslab2024.observer.Subject;
import ro.uvt.info.designpatternslab2024.services.BooksService;

public class CreateBookCommand implements Command {
    private final BooksService booksService;
    private final Subject allBooksSubject;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Subject allBooksSubject, Book book) {
        this.booksService = booksService;
        this.allBooksSubject = allBooksSubject;
        this.book = book;
    }

    @Override
    public void execute() {
        booksService.addBook(book);
        allBooksSubject.notifyObservers(book); // Notifică observatorii
        System.out.println("Book created and observers notified: " + book.getTitle());
    }
}
