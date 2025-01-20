package ro.uvt.info.designpatternslab2024.persistence;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2024.models.Author;

@Component
public class AuthorRepositoryAdapter extends CrudRepositoryAdapter<Author, Long> {
    public AuthorRepositoryAdapter(AuthorsRepository authorRepository) {
        super(authorRepository); // Transmite repository-ul specific
    }
}

