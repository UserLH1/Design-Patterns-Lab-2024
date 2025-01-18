package ro.uvt.info.designpatternslab2024.observer;

import ro.uvt.info.designpatternslab2024.models.Book;

public interface Observer {
    void update(Book book);
}
