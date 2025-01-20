package ro.uvt.info.designpatternslab2024.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.info.designpatternslab2024.models.Author;

public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
