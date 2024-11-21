package ro.uvt.info.designpatternslab2024.bookmodel;

import ro.uvt.info.designpatternslab2024.bookmodel.Element;
import ro.uvt.info.designpatternslab2024.strategy.AlignStrategy;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
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
