package com.sri.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class DecryptPdf {

    public static void main(String[] args) throws IOException {
        PDDocument pd = PDDocument.load(new File("/Users/srinath.rayabarapu/Desktop/Home Loans/SBI-Naveen/My-Docs/7. ITR/AY_2022-23_ITR_csbps6004b28121985.pdf"),
                "csbps6004b28121985");
        pd.setAllSecurityToBeRemoved(true);
        pd.save("/Users/srinath.rayabarapu/Desktop/Home Loans/SBI-Naveen/My-Docs/7. ITR/AY_2022-23_ITR_csbps6004b28121985-Decrypted.pdf");
    }

}