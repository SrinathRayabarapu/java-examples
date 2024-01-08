package com.proj.qrcodegenerator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * zxing library is used to generate matrix QR code - for any alphanumeric text
 * barbecue library is used to generate linear QR code - mainly for digits
 */
@Slf4j
public class GenerateQRCodeMain {

    public static void main(String[] args) throws WriterException, IOException {

        String qrCodeToBeGeneratedURL = "https://www.youtube.com/watch?v=9j-i-o7vx1c&ab_channel=TechStack9";
        log.info("Generating QR Code for : {}", qrCodeToBeGeneratedURL);

        // get the current project path
        String pathToSaveQRCodes = System.getProperty("user.dir") + "/proj_generating-qr-code/src/main/resources/qrcodes/TechStack9.png";

        generateQRCode(qrCodeToBeGeneratedURL, pathToSaveQRCodes, 500, 500);

        log.info("QR Code successfully generated!");
    }

    private static void generateQRCode(String qrCodeToBeGeneratedURL, String pathToSaveQRCodes, int width, int height) throws WriterException, IOException {

        BitMatrix bitMatrix = new MultiFormatWriter().encode(qrCodeToBeGeneratedURL, BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToPath(bitMatrix, pathToSaveQRCodes.substring(pathToSaveQRCodes.lastIndexOf(".")+1), Paths.get(pathToSaveQRCodes));
    }

}