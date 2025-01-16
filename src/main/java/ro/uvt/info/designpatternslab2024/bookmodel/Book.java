package ro.uvt.info.designpatternslab2024.bookmodel;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Element> elements = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public Book(String title)
    {
        this.title=title;
    }
    public void addAuthor(Author authors)
    {

        this.authors.add(authors);
    }
    public void addContent(Element element) {
        this.elements.add(element);
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

    public Integer getId() {
    }
}
