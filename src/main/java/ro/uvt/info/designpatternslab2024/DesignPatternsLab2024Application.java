package ro.uvt.info.designpatternslab2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import ro.uvt.info.designpatternslab2024.services.BooksService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class DesignPatternsLab2024Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DesignPatternsLab2024Application.class, args);
    }}