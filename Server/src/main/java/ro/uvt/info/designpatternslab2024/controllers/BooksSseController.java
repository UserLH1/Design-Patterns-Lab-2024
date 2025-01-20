package ro.uvt.info.designpatternslab2024.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2024.commands.SseCommand;
import ro.uvt.info.designpatternslab2024.components.AllBooksSubject;

@RestController
public class BooksSseController {
    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books-sse")
    public SseEmitter getBooksSse() {
        SseEmitter emitter = new SseEmitter(60_000L);
        SseCommand command = new SseCommand(allBooksSubject, emitter);
        command.execute(); // Execută comanda pentru logica SSE
        return emitter;
    }
}
