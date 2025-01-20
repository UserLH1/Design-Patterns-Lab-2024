package ro.uvt.info.designpatternslab2024.services;

import ro.uvt.info.designpatternslab2024.models.Paragraph;
import ro.uvt.info.designpatternslab2024.strategies.AlignStrategy;

public interface ParagraphAlignmentService {
    void alignParagraph(Paragraph paragraph, AlignStrategy alignStrategy);
}
