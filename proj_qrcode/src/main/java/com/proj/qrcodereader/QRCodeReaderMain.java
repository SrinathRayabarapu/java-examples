package com.proj.qrcodereader;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class QRCodeReaderMain {

    public static void main(String[] args) throws IOException, NotFoundException {

        String pathToSavedQRCodes = System.getProperty("user.dir") + "/proj_generating-qr-code/src/main/resources/qrcodes/TechStack9.png";

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(pathToSavedQRCodes)))));

        String imageText = new MultiFormatReader().decode(binaryBitmap).getText();

        log.info("QR Code image text : {}", imageText);
    }

}