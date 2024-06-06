package com.srinath.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.Matrix;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Rotates pdf
 */
public class RotatePDF {

    public static void main(String[] args) throws IOException {

        try (InputStream resource = new FileInputStream("/Users/srinath.rayabarapu/Desktop/1286_001.pdf")) {

            PDDocument document = PDDocument.load(resource);

            for (PDPage page : document.getDocumentCatalog().getPages()){
                PDPageContentStream cs = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.PREPEND, false, false);
                Matrix matrix = Matrix.getRotateInstance(Math.toRadians(90), 0, 0);
                cs.transform(matrix);
                cs.close();

                PDRectangle cropBox = page.getCropBox();
                Rectangle rectangle = cropBox.transform(matrix).getBounds();
                PDRectangle newBox = new PDRectangle((float) rectangle.getX(), (float) rectangle.getY(), (float) rectangle.getWidth(), (float) rectangle.getHeight());
                page.setCropBox(newBox);
                page.setMediaBox(newBox);
            }

            document.save(new File("/Users/srinath.rayabarapu/Desktop/1286_001_Rotated.pdf"));
            System.out.println("Done rotating!!");
        }

    }

}
