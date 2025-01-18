package ro.uvt.info.designpatternslab2024.models;

import jakarta.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
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
