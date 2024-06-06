package com.srinath.pdf;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

@Slf4j
public class DecryptPdf {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/srinath.rayabarapu/Desktop/Home Loans/SBI-Naveen/My-Docs/7. ITR";
        PDDocument pd = PDDocument.load(new File(basePath + "/AY_2022-23_ITR_csbps6004b28121985.pdf"), "csbps6004b28121985");
        pd.setAllSecurityToBeRemoved(true);
        pd.save(basePath + "/AY_2022-23_ITR_csbps6004b28121985-Decrypted.pdf");
        log.info("Decrypted pdf file successfully!");
    }
}