package ro.uvt.info.designpatternslab2024.components;

import lombok.Getter;
import lombok.Setter;
import ro.uvt.info.designpatternslab2024.models.Book;
import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2024.observer.Observer;
import ro.uvt.info.designpatternslab2024.observer.Subject;

import java.util.ArrayList;
import java.util.List;
@Component
public class AllBooksSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    public AllBooksSubject() {
        System.out.println("New AllBooksSubject instance created: " + this);
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer attached: " + observer.getClass().getSimpleName());
        }
        System.out.println("Current observers: " + observers.size());
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer detached: " + observer.getClass().getSimpleName());
        System.out.println("Current observers after detach: " + observers.size());
    }

    @Override
    public void notifyObservers(Book book) {
        System.out.println("Notifying observers about book: " + book.getTitle());
        System.out.println("Total observers: " + observers.size());

        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
