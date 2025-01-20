package ro.uvt.info.designpatternslab2024.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2024.models.Author;
import ro.uvt.info.designpatternslab2024.models.Book;
import ro.uvt.info.designpatternslab2024.models.Element;
import ro.uvt.info.designpatternslab2024.models.Section;
import ro.uvt.info.designpatternslab2024.components.AllBooksSubject;
import ro.uvt.info.designpatternslab2024.observer.Subject;
import ro.uvt.info.designpatternslab2024.persistence.AuthorsRepository;
import ro.uvt.info.designpatternslab2024.persistence.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final AllBooksSubject allBooksSubject;
    private final AuthorsRepository authorsRepository; // Adăugat

    public BooksService(BooksRepository booksRepository, AllBooksSubject allBooksSubject,  AuthorsRepository authorsRepository) {
        this.booksRepository = booksRepository;
        this.allBooksSubject = allBooksSubject;
        this.authorsRepository = authorsRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Transactional
    public void addBook(Book book) {
        System.out.println("Adding book: " + book.getTitle());
        // Salvează autorii
        for (Author author : book.getAuthors()) {
            if (author.getId() == null || !authorsRepository.existsById(author.getId())) {
                authorsRepository.save(author);
            }
        }

        // Persistă secțiunile și subsecțiunile recursiv
        for (Section section : book.getSections()) {
            System.out.println("Persisting section: " + section.getTitle());
            persistSectionRecursively(section);
        }

        // Salvează cartea
        booksRepository.save(book);

        // Notifică observatorii
        allBooksSubject.notifyObservers(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Metodă recursivă pentru a salva secțiunile și subsecțiunile
    private void persistSectionRecursively(Section section) {
        // Persistă elementele din secțiune
        for (Element element : section.getElements()) {
            // Adaugă logici suplimentare dacă este necesar
            System.out.println("Persisting element: " + element.getClass().getSimpleName());
        }

        // Persistă subsecțiunile recursiv
        for (Section subSection : section.getSubSections()) {
            persistSectionRecursively(subSection);
        }
    }



    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    @Transactional
    public void updateBook(Long id, Book updatedBook) {
        Optional<Book> existingBookOpt = booksRepository.findById(id);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();

            // Actualizează titlul
            existingBook.setTitle(updatedBook.getTitle());

            // Actualizează lista de autori
            existingBook.getAuthors().clear();
            existingBook.getAuthors().addAll(updatedBook.getAuthors());

            // Actualizează colecția elements
            existingBook.getElements().clear();
            existingBook.getElements().addAll(updatedBook.getElements());

            // Salvează modificările
            booksRepository.save(existingBook);
        } else {
            throw new EntityNotFoundException("Book not found with ID: " + id);
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

    public Subject getAllBooksSubject() {
        return allBooksSubject;
    }
}
