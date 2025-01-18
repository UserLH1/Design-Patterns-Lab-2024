package ro.uvt.info.designpatternslab2024.models;

import lombok.Getter;
import lombok.Setter;
import ro.uvt.info.designpatternslab2024.strategies.AlignStrategy;
@Getter
@Setter
public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add elements to a Paragraph.");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove elements from a Paragraph.");
    }

    @Override
    public void print() {

        if (alignStrategy != null) {
            System.out.println("Paragraph: " + alignStrategy.render(text));
        }
        else {
            System.out.println("Paragraph: " + text);
        }

    }

}
