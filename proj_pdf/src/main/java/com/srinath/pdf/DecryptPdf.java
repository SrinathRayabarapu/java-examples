package com.srinath.pdf;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

@Slf4j
public class DecryptPdf {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/srinath.rayabarapu/Desktop/";
        PDDocument pd = PDDocument.load(new File(basePath + "EAadhaar_0221013910026020250322163245_25032025112437.pdf")
                , "HITH2020");
        pd.setAllSecurityToBeRemoved(true);
        pd.save(basePath + "/Hitharsh.SR-Aadhar.pdf");
        log.info("Decrypted pdf file successfully!");
    }
}