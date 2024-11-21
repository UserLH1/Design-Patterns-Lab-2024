package ro.uvt.info.designpatternslab2024;

public class Paragraph implements Element {
    private String text;

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
        System.out.println("Paragraph: " + text);
    }
}
