package ro.uvt.info.designpatternslab2024.models;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data //metode de getter si setter din lombok

@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany
    private List<Element> elements = new ArrayList<>();

    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    public Book(String title)
    {
        this.title=title;
    }
    public void addAuthor(Author authors)
    {

        this.authors.add(authors);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        for (Element element : elements) {
            System.out.println("Element:");
            element.print();
        }
    }
}
