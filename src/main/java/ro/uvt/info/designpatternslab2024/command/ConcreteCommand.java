package ro.uvt.info.designpatternslab2024.command;

import lombok.RequiredArgsConstructor;
import ro.uvt.info.designpatternslab2024.bookmodel.Book;
import ro.uvt.info.designpatternslab2024.bookservice.BookService;

@RequiredArgsConstructor
public class AddBookCommand implements CommandInterface {
    private final BookService bookService;
    private final Book book;

    @Override
    public void execute() {
        bookService.addBook(book);
    }
}

@RequiredArgsConstructor
public class DeleteBookCommand implements CommandInterface {
    private final BookService bookService;
    private final int bookId;

    @Override
    public void execute() {
        bookService.deleteBook(bookId);
    }
}
