package ro.uvt.info.designpatternslab2024.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TableOfContents extends ConcreteElement {

    @Column(nullable = false)
    private String content;

    public TableOfContents(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("Table: " + content);
    }
}
