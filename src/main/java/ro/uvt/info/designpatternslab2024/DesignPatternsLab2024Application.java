package ro.uvt.info.designpatternslab2024;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.uvt.info.designpatternslab2024.bookmodel.*;
import ro.uvt.info.designpatternslab2024.strategy.AlignLeft;
import ro.uvt.info.designpatternslab2024.strategy.AlignRight;

@SpringBootApplication
public class DesignPatternsLab2024Application {

    public static void main(String[] args) {
        //SpringApplication.run(DesignPatternsLab2024Application.class, args);
        Book noapteBuna = new Book("Noapte buna, copii!");
        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);
        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Capitolul 1.1.1.1");

        noapteBuna.addContent(new Paragraph("Multumesc celor care ..."));
        noapteBuna.addContent(cap1);
        Paragraph p1=new Paragraph("Text from subchapter 1.1");

        p1.setAlignStrategy(new AlignRight());

        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(p1);
        cap11.add(cap111);
        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(cap1111);
        cap1111.add(new Image("Image subchapter 1.1.1.1"));

        noapteBuna.print();
    }

}
