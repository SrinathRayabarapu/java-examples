package com.srinath.pdf;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;

@Slf4j
public class MergePdf {
    public static void main(String[] args) throws IOException {

        String basePath = "/Users/srinath.rayabarapu/Desktop";

        // loading all the pdf files we wish to merge
        File file1 = new File(basePath + "/PME-Bill.pdf");
        File file2 = new File(basePath + "/Doctor-Advice.pdf");
//        File file3 = new File(basePath + "/BLR_Airport-Home2.pdf");

        // Instantiating PDFMergerUtility class
        PDFMergerUtility obj = new PDFMergerUtility();

        // Setting the destination file path
        obj.setDestinationFileName(basePath + "/PME-All-Docs.pdf");

        // Add all source files, to be merged
        obj.addSource(file1);
        obj.addSource(file2);
//        obj.addSource(file3);

        // Merging documents
        obj.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        log.info("PDF Documents merged to a Single file!");
    }

}
