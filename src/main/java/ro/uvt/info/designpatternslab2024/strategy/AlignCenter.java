package ro.uvt.info.designpatternslab2024.strategy;

public class AlignCenter implements AlignStrategy {
    @Override
    public String render(String text) {
        int padding = (50 - text.length()) / 2; // 50 este lățimea simulată
        System.out.println(" ".repeat(Math.max(0, padding)) + text);
        return text;
    }
}