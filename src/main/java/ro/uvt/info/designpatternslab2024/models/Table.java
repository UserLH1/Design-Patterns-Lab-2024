package ro.uvt.info.designpatternslab2024.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Table")
@Data
@NoArgsConstructor
public class Table extends ConcreteElement {

    @Column(nullable = false)
    private String content;

    public Table(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("Table: " + content);
    }
}
