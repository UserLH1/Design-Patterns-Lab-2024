package ro.uvt.info.designpatternslab2024.observer;

import lombok.Getter;
import lombok.Setter;
import ro.uvt.info.designpatternslab2024.models.Book;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class AllBooksSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        System.out.println("Notifying observers about book: " + book.getTitle());
        for (Observer observer : observers) {
            System.out.println("Notifying observer: " + observer.getClass().getName());
            observer.update(book);
        }
    }
}
