package com.srinath.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CreatePDFFromImage {

    public static void main(String[] args) throws IOException {
        CreatePDFFromImage app = new CreatePDFFromImage();
        app.createPDFFromImage("/Users/srinath.rayabarapu/Desktop/20250203_072527.jpg", "/Users/srinath.rayabarapu/Desktop/PME-Bill.pdf");
        System.out.println("Created PDF!!");
    }

    public void createPDFFromImage(String imagePath, String outputFile)
            throws IOException {
        try (PDDocument doc = new PDDocument()) {
            InputStream in = new FileInputStream(imagePath);
            BufferedImage bimg = ImageIO.read(in);
            float width = bimg.getWidth();
            float height = bimg.getHeight();
            PDPage page = new PDPage(new PDRectangle(width, height));
            doc.addPage(page);
            PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);
            try (PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
                float scale = 1f;
                contentStream.drawImage(pdImage, 20, 20, pdImage.getWidth() * scale, pdImage.getHeight() * scale);
            }
            doc.save(outputFile);
        }
    }

}
