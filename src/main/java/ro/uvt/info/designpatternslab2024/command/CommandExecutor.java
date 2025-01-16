package ro.uvt.info.designpatternslab2024.command;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CommandExecutor {
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public void execute(ConcreteCommand command, boolean async) {
        if (async) {
            executor.submit(command::execute);
        } else {
            command.execute();
        }
    }
}
