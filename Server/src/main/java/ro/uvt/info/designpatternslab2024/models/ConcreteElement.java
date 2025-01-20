package ro.uvt.info.designpatternslab2024.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ConcreteElement implements Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Operation not supported for this element.");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Operation not supported for this element.");
    }
}
