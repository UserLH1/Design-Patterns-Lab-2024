package ro.uvt.info.designpatternslab2024.bookmodel;

public class Author {
    private String name;

    public Author(String name)
    {
        this.name=name;
    }
    void add(Author author)
    {

    }
    public void print()
    {
        System.out.println("Author: " + name);
    }
}
