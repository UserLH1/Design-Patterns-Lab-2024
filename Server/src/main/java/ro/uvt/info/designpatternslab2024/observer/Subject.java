package ro.uvt.info.designpatternslab2024.observer;

import ro.uvt.info.designpatternslab2024.models.Book;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Book book);
}
