package ro.uvt.info.designpatternslab2024.strategy;

public class AlignRight implements AlignStrategy{
    @Override
    public String render(String paragraph) {
        System.out.println(paragraph + ">>");
        return paragraph;
    }
}