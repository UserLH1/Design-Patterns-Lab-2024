package ro.uvt.info.designpatternslab2024.models;

public class Image implements Element {
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add elements to an Image.");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove elements from an Image.");
    }

    @Override
    public void print() {
        System.out.println("Image: " + imageName);
    }
}
