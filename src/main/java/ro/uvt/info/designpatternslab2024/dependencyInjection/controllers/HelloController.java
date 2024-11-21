package ro.uvt.info.designpatternslab2024.dependencyInjection.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.info.designpatternslab2024.dependencyInjection.components.ClientComponent;

@RestController
public class HelloController {
    private final ClientComponent clientComponent;

    public HelloController(ClientComponent clientComponent) {
        this.clientComponent = clientComponent;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from " + clientComponent.toString();
    }
}
