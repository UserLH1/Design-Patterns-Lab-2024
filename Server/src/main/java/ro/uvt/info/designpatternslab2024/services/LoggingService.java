package ro.uvt.info.designpatternslab2024.services;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Enumeration;

@Service
public class LoggingService {

    public void logRequest(ServletRequest request) {
        if (request instanceof HttpServletRequest httpRequest) {
            System.out.println("----- Logging Request Details -----");
            System.out.println("Method: " + httpRequest.getMethod());
            System.out.println("Request URL: " + httpRequest.getRequestURL());
            System.out.println("Query String: " + httpRequest.getQueryString());
            System.out.println("Remote Address: " + request.getRemoteAddr());
            System.out.println("Headers:");

            Enumeration<String> headerNames = httpRequest.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println("  " + headerName + ": " + httpRequest.getHeader(headerName));
            }

            System.out.println("Parameters:");
            httpRequest.getParameterMap().forEach((key, value) ->
                    System.out.println("  " + key + ": " + String.join(", ", value))
            );
            System.out.println("------------------------------------");
        } else {
            System.out.println("Logging request: " + request.toString());
        }
    }

    public void logResponse(ServletResponse response) {
        if (response instanceof HttpServletResponse httpResponse) {
            System.out.println("----- Logging Response Details -----");
            System.out.println("Status: " + httpResponse.getStatus());

            // Din păcate, HttpServletResponse nu oferă acces direct la body-ul răspunsului,
            // dar poți intercepta răspunsul folosind un wrapper dacă este necesar.

            System.out.println("------------------------------------");
        } else {
            System.out.println("Logging response: " + response.toString());
        }
    }
}
