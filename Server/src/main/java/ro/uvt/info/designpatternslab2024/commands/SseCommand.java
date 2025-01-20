package ro.uvt.info.designpatternslab2024.commands;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2024.components.AllBooksSubject;
import ro.uvt.info.designpatternslab2024.observer.SseObserver;

public class SseCommand implements Command {
    private final AllBooksSubject allBooksSubject;
    private final SseEmitter emitter;
    private final SseObserver observer;

    public SseCommand(AllBooksSubject allBooksSubject, SseEmitter emitter) {
        this.allBooksSubject = allBooksSubject;
        this.emitter = emitter;
        this.observer = new SseObserver(emitter);
    }

    @Override
    public void execute() {
        // Atașează observatorul
        allBooksSubject.attach(observer);
        System.out.println("Observer attached.");

        // Gestionarea onCompletion
        emitter.onCompletion(() -> {
            allBooksSubject.detach(observer);
            System.out.println("SSE connection completed.");
        });

        // Gestionarea onTimeout
        emitter.onTimeout(() -> {
            allBooksSubject.detach(observer);
            System.out.println("SSE connection timed out.");
        });
    }
}
