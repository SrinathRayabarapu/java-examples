package com.srinath.pdf;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;

/**
 * Utility class for merging multiple PDF files into a single document.
 * 
 * <p>This class uses Apache PDFBox library's {@link PDFMergerUtility} to combine
 * PDF documents while preserving their content, formatting, and structure.</p>
 * 
 * <h3>Features:</h3>
 * <ul>
 *   <li>Merge any number of PDF files</li>
 *   <li>Preserve original document formatting</li>
 *   <li>Configurable memory usage settings</li>
 *   <li>Support for large documents via temp file mode</li>
 * </ul>
 * 
 * <h3>Memory Considerations:</h3>
 * <p>For large PDFs, consider using:</p>
 * <ul>
 *   <li>{@code MemoryUsageSetting.setupTempFileOnly()} - For very large files</li>
 *   <li>{@code MemoryUsageSetting.setupMixed(threshold)} - Balanced approach</li>
 * </ul>
 * 
 * <h3>Usage:</h3>
 * <pre>{@code
 * PDFMergerUtility merger = new PDFMergerUtility();
 * merger.addSource(new File("doc1.pdf"));
 * merger.addSource(new File("doc2.pdf"));
 * merger.setDestinationFileName("merged.pdf");
 * merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
 * }</pre>
 * 
 * @author Srinath.Rayabarapu
 * @see PDFMergerUtility
 * @see MemoryUsageSetting
 */
@Slf4j
public class MergePdf {
    
    /**
     * Main method demonstrating PDF merging functionality.
     * 
     * <p><b>Note:</b> Update the file paths to point to actual PDF files
     * on your system before running.</p>
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file reading or writing fails
     */
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
