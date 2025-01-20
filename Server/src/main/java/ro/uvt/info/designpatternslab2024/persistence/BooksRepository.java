package ro.uvt.info.designpatternslab2024.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.designpatternslab2024.models.Book;

@Repository
public interface BooksRepository extends JpaRepository <Book, Long>{

}
