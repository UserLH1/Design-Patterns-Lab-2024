package ro.uvt.info.designpatternslab2024.models;

import jakarta.persistence.Entity;


public interface Element {
    void add(Element element);
    void remove(Element element);
    void print();
}
