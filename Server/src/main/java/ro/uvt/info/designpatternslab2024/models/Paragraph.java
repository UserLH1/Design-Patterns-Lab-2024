package ro.uvt.info.designpatternslab2024.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.uvt.info.designpatternslab2024.strategies.AlignStrategy;

@Entity
@Data
@NoArgsConstructor
public class Paragraph extends ConcreteElement {
    @Column(nullable = false)
    private String text;

    @Transient
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            System.out.println("Paragraph: " + alignStrategy.render(text));
        } else {
            System.out.println("Paragraph: " + text);
        }
    }
}
