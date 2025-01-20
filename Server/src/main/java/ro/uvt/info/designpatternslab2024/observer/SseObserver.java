package ro.uvt.info.designpatternslab2024.observer;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2024.models.Book;

import java.io.IOException;

public class SseObserver implements Observer {
    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        System.out.println("update method called");
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
            System.out.println("Emmiter sent this:" + MediaType.APPLICATION_JSON);
            System.out.println("Sent book to observer: " + book.getTitle());
        } catch (IllegalStateException e) {
            System.err.println("SSE connection is no longer valid.");
        } catch (IOException e) {
            emitter.completeWithError(e);
            System.err.println("Error sending SSE: " + e.getMessage());
        }
        System.out.println("update method finished for book: " + book.getTitle());

    }


}
