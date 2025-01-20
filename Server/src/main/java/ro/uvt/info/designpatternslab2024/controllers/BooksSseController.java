package ro.uvt.info.designpatternslab2024.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2024.observer.AllBooksSubject;
import ro.uvt.info.designpatternslab2024.observer.SseObserver;

@RestController
public class BooksSseController {
    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books-sse")
    public SseEmitter getBooksSse() {
        SseEmitter emitter = new SseEmitter(60_000L);
        SseObserver sseObserver = new SseObserver(emitter);

        allBooksSubject.attach(sseObserver);
        System.out.println("Observer attached.");

        emitter.onCompletion(() -> {
            allBooksSubject.detach(sseObserver);
            System.out.println("SSE connection completed.");
        });

        emitter.onTimeout(() -> {
            allBooksSubject.detach(sseObserver);
            System.out.println("SSE connection timed out.");
        });

        return emitter;
    }
}
