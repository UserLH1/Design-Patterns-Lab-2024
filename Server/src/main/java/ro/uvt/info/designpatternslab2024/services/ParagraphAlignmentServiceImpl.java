package ro.uvt.info.designpatternslab2024.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2024.models.Paragraph;
import ro.uvt.info.designpatternslab2024.strategies.AlignStrategy;

@Service
public class ParagraphAlignmentServiceImpl implements ParagraphAlignmentService {

    @Override
    public void alignParagraph(Paragraph paragraph, AlignStrategy alignStrategy) {
        paragraph.setAlignStrategy(alignStrategy);
        System.out.println("Aligned paragraph: " + alignStrategy.render(paragraph.getText()));
    }
}
