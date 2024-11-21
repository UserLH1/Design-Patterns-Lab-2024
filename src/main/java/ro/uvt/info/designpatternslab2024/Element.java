package ro.uvt.info.designpatternslab2024;

public interface Element {
    void add(Element element);
    void remove(Element element);
    void print();
}
