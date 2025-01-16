package ro.uvt.info.designpatternslab2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import ro.uvt.info.designpatternslab2024.bookmodel.*;
import ro.uvt.info.designpatternslab2024.dependencyInjection.components.ClientComponent;
import ro.uvt.info.designpatternslab2024.dependencyInjection.components.SingletonComponent;
import ro.uvt.info.designpatternslab2024.dependencyInjection.components.TransientComponent;
import ro.uvt.info.designpatternslab2024.services.BooksService;
import ro.uvt.info.designpatternslab2024.strategy.AlignLeft;
import ro.uvt.info.designpatternslab2024.strategy.AlignRight;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DesignPatternsLab2024Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DesignPatternsLab2024Application.class, args);

        // Obține referința către BooksService
        BooksService booksService = context.getBean(BooksService.class);

        // Adaugă cărți folosind BooksService (simulează un POST)
        booksService.addBook("carte1");
        booksService.addBook("carte2");

        // Afișează lista de cărți (simulează un GET)
        System.out.println("All books:");
        booksService.getAllBooks().forEach(System.out::println);

        // Obține detalii despre o carte specifică (simulează un GET cu ID)
        System.out.println("Book at ID 0: " + booksService.getBookById(0));

        // Updatează o carte (simulează un PUT)
        booksService.updateBook(1, "new carte");
        System.out.println("Updated book list:");
        booksService.getAllBooks().forEach(System.out::println);

        // Șterge o carte (simulează un DELETE)
        booksService.deleteBook(0);
        System.out.println("Final book list after deletion:");
        booksService.getAllBooks().forEach(System.out::println);


//        ApplicationContext context = SpringApplication.run(DesignPatternsLab2024Application.class, args);
//
//        TransientComponent transientBean = context.getBean(TransientComponent.class);
//        transientBean.operation();
//
//        transientBean = context.getBean(TransientComponent.class);
//        transientBean.operation();
//
//        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
//        singletonBean.operation();
//
//        ClientComponent clientBean = context.getBean(ClientComponent.class);
//        clientBean.operation();
//        Book noapteBuna = new Book("Noapte buna, copii!");
//        Author rpGheo = new Author("Radu Pavel Gheo");
//        noapteBuna.addAuthor(rpGheo);
//        Section cap1 = new Section("Capitolul 1");
//        Section cap11 = new Section("Capitolul 1.1");
//        Section cap111 = new Section("Capitolul 1.1.1");
//        Section cap1111 = new Section("Capitolul 1.1.1.1");
//
//        noapteBuna.addContent(new Paragraph("Multumesc celor care ..."));
//        noapteBuna.addContent(cap1);
//        Paragraph p1=new Paragraph("Text from subchapter 1.1");
//
//        p1.setAlignStrategy(new AlignRight());
//
//        cap1.add(new Paragraph("Moto capitol"));
//        cap1.add(cap11);
//        cap11.add(p1);
//        cap11.add(cap111);
//        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
//        cap111.add(cap1111);
//        cap1111.add(new Image("Image subchapter 1.1.1.1"));
//
//        noapteBuna.print();
    }

}
