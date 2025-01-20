package ro.uvt.info.designpatternslab2024.persistence;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2024.models.Book;

@Component
public class BookRepositoryAdapter extends CrudRepositoryAdapter<Book, Long> {
    public BookRepositoryAdapter(BooksRepository booksRepository) {
        super(booksRepository); // Transmite repository-ul specific
    }
}
