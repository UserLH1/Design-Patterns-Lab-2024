package ro.uvt.info.designpatternslab2024.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Image")
@Data
@NoArgsConstructor
public class Image extends ConcreteElement {

    @Column(nullable = false)
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image: " + url);
    }
}
