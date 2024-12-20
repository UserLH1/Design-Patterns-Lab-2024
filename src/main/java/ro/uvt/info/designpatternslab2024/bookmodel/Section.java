package ro.uvt.info.designpatternslab2024.bookmodel;

import ro.uvt.info.designpatternslab2024.bookmodel.Element;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element element : elements) {
            element.print();
        }
    }
}
