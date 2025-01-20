package ro.uvt.info.designpatternslab2024.commands;

import ro.uvt.info.designpatternslab2024.models.Book;
import ro.uvt.info.designpatternslab2024.observer.Subject;
import ro.uvt.info.designpatternslab2024.services.BooksService;

public class UpdateBookCommand implements Command {
    private final BooksService booksService;
    private final Subject allBooksSubject;
    private final Long bookId;
    private final Book updatedBook;

    public UpdateBookCommand(BooksService booksService, Subject allBooksSubject, Long bookId, Book updatedBook) {
        this.booksService = booksService;
        this.allBooksSubject = allBooksSubject;
        this.bookId = bookId;
        this.updatedBook = updatedBook;
    }

    @Override
    public void execute() {
        booksService.updateBook(bookId, updatedBook);
        allBooksSubject.notifyObservers(updatedBook); // Notifică observatorii
        System.out.println("Book updated and observers notified: " + updatedBook.getTitle());
    }
}
