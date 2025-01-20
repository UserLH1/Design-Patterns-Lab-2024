package ro.uvt.info.designpatternslab2024.commands;

import ro.uvt.info.designpatternslab2024.models.Book;
import ro.uvt.info.designpatternslab2024.observer.Subject;
import ro.uvt.info.designpatternslab2024.services.BooksService;

public class DeleteBookCommand implements Command {
    private final BooksService booksService;
    private final Subject allBooksSubject;
    private final Long bookId;

    public DeleteBookCommand(BooksService booksService, Subject allBooksSubject, Long bookId) {
        this.booksService = booksService;
        this.allBooksSubject = allBooksSubject;
        this.bookId = bookId;
    }

    @Override
    public void execute() {
        booksService.deleteBook(bookId);
        Book deletedBook = new Book(); // Creează o carte fictivă doar pentru notificare
        deletedBook.setId(bookId);
        deletedBook.setTitle("Deleted Book");
        allBooksSubject.notifyObservers(deletedBook); // Notifică observatorii
        System.out.println("Book deleted and observers notified with ID: " + bookId);
    }
}
