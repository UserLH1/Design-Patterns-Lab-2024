package ro.uvt.info.designpatternslab2024.chaincommand.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public interface Filter {


    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;
}
