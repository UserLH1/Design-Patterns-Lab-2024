package ro.uvt.info.designpatternslab2024.bookmodel;

public interface Element {
    void add(Element element);
    void remove(Element element);
    void print();
}
