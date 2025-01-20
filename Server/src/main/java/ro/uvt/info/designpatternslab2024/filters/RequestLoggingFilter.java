package ro.uvt.info.designpatternslab2024.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2024.services.LoggingService;

import java.io.IOException;

@Component
@WebFilter
public class RequestLoggingFilter implements Filter {

    private final LoggingService loggingService;

    public RequestLoggingFilter(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        loggingService.logRequest(request);
        chain.doFilter(request, response); // Continuă procesarea cererii
        loggingService.logResponse(response);
    }
}
