package com.sri.pdf;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;

@Slf4j
public class MergePdf {
    public static void main(String[] args) throws IOException {

        String basePath = "/Users/srinath.rayabarapu/My Drive/Travel Docs/Office/Travel Tickets/17:22-12-23/Bills/21.BLR_Airport-Home";

        // loading all the pdf files we wish to merge
        File file1 = new File(basePath + "/BLR_Airport-Home.pdf");
        File file2 = new File(basePath + "/BLR_Airport-Home1.pdf");
        File file3 = new File(basePath + "/BLR_Airport-Home2.pdf");

        // Instantiating PDFMergerUtility class
        PDFMergerUtility obj = new PDFMergerUtility();

        // Setting the destination file path
        obj.setDestinationFileName(basePath + "/BLR_Airport-Home-All.pdf");

        // Add all source files, to be merged
        obj.addSource(file1);
        obj.addSource(file2);
        obj.addSource(file3);

        // Merging documents
        obj.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        log.info("PDF Documents merged to a Single file!");
    }

}
