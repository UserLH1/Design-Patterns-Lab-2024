package ro.uvt.info.designpatternslab2024.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2024.observer.AllBooksSubject;
import ro.uvt.info.designpatternslab2024.observer.SseObserver;

@RestController
public class BooksSseController {
    private final AllBooksSubject allBooksSubject = new AllBooksSubject();

    @GetMapping("/books-sse")
    public SseEmitter getBooksSse() {
        SseEmitter emitter = new SseEmitter(0L);

        allBooksSubject.attach(new SseObserver(emitter));
        System.out.println("Observer attached.");
        emitter.onCompletion(() -> allBooksSubject.detach(new SseObserver(emitter)));
        emitter.onTimeout(() -> allBooksSubject.detach(new SseObserver(emitter)));

        return emitter;
    }

    public AllBooksSubject getAllBooksSubject() {
        return allBooksSubject;
    }
}
