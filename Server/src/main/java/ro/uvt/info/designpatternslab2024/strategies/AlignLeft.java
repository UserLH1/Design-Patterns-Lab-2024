package ro.uvt.info.designpatternslab2024.strategies;

public class AlignLeft implements AlignStrategy {
    @Override
    public String render(String paragraph) {
        System.out.println("<<" + paragraph);
        return paragraph;
    }

}
