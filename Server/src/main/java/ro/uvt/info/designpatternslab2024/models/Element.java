package ro.uvt.info.designpatternslab2024.models;

import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Paragraph.class, name = "Paragraph"),
        @JsonSubTypes.Type(value = Image.class, name = "Image"),
        @JsonSubTypes.Type(value = TableOfContents.class, name = "Table"),
        @JsonSubTypes.Type(value = Section.class, name = "Section")
})
public interface Element {
    void add(Element element);
    void remove(Element element);
    void print();
}

