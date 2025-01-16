package ro.uvt.info.designpatternslab2024.chaincommand.filters;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;


import java.io.IOException;
@WebFilter("/*")
public class RequestLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Before processing request: " + request);
        chain.doFilter(request, response);
        System.out.println("After processing request: " + response);
    }

}
