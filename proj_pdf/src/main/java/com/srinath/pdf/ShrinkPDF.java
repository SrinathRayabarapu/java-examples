package com.srinath.pdf;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
public class ShrinkPDF {

    public static void main(String[] args) {

        try {
            PDDocument pdDocument = new PDDocument();
            String fileName = "/Users/srinath.rayabarapu/Desktop/PME-All-Docs.pdf";
            log.info("Reading the file : {}", fileName);

            PDDocument oDocument = PDDocument.load(new File(fileName));
            PDFRenderer pdfRenderer = new PDFRenderer(oDocument);
            int numberOfPages = oDocument.getNumberOfPages();
            PDPage page;

            for (int i = 0; i < numberOfPages; i++) {
                page = new PDPage(PDRectangle.LETTER);
                BufferedImage bim = pdfRenderer.renderImageWithDPI(i, 300, ImageType.RGB);
                PDImageXObject pdImage = JPEGFactory.createFromImage(pdDocument, bim);
                PDPageContentStream contentStream = new PDPageContentStream(pdDocument, page);
                float newHeight = PDRectangle.LETTER.getHeight();
                float newWidth = PDRectangle.LETTER.getWidth();
                contentStream.drawImage(pdImage, 0, 0, newWidth, newHeight);
                contentStream.close();

                pdDocument.addPage(page);
            }
            String toFileName = "/Users/srinath.rayabarapu/Desktop/PME-All-Docs_Shrinked.pdf";
            pdDocument.save(toFileName);
            pdDocument.close();
            log.info("Saved to file : {}", toFileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
