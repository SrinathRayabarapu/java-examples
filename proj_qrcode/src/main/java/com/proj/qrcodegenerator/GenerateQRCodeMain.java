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
 * Utility class for generating QR codes from text or URLs.
 * 
 * <p>This class uses the ZXing (Zebra Crossing) library to generate 2D matrix
 * barcodes (QR codes) that can encode any alphanumeric text.</p>
 * 
 * <h3>Supported Libraries:</h3>
 * <ul>
 *   <li><b>ZXing</b> - For 2D matrix QR codes (alphanumeric content)</li>
 *   <li><b>Barbecue</b> - For 1D linear barcodes (primarily numeric)</li>
 * </ul>
 * 
 * <h3>QR Code Capabilities:</h3>
 * <ul>
 *   <li>Encode URLs, text, contact information</li>
 *   <li>Customizable dimensions (width x height)</li>
 *   <li>Multiple output formats (PNG, JPEG, GIF)</li>
 *   <li>Error correction for damaged/partial codes</li>
 * </ul>
 * 
 * <h3>Usage:</h3>
 * <pre>{@code
 * String content = "https://example.com";
 * String outputPath = "qrcode.png";
 * generateQRCode(content, outputPath, 500, 500);
 * }</pre>
 * 
 * @author Srinath.Rayabarapu
 * @see MultiFormatWriter
 * @see BarcodeFormat
 */
@Slf4j
public class GenerateQRCodeMain {

    /**
     * Main method demonstrating QR code generation.
     * 
     * <p><b>Note:</b> Update the output path to a valid location
     * on your system before running.</p>
     *
     * @param args command-line arguments (not used)
     * @throws WriterException if QR code encoding fails
     * @throws IOException if file writing fails
     */
    public static void main(String[] args) throws WriterException, IOException {

        String qrCodeToBeGeneratedURL = "https://www.youtube.com/watch?v=9j-i-o7vx1c&ab_channel=TechStack9";
        log.info("Generating QR Code for : {}", qrCodeToBeGeneratedURL);

        // get the current project path
        String pathToSaveQRCodes = System.getProperty("user.dir") + "/proj_generating-qr-code/src/main/resources/qrcodes/TechStack9.png";

        generateQRCode(qrCodeToBeGeneratedURL, pathToSaveQRCodes, 500, 500);

        log.info("QR Code successfully generated!");
    }

    /**
     * Generates a QR code image from the given content.
     * 
     * <p>The image format is determined from the file extension in the path.</p>
     *
     * @param qrCodeToBeGeneratedURL the content to encode (URL, text, etc.)
     * @param pathToSaveQRCodes the full path where the QR code image will be saved
     * @param width the width of the QR code image in pixels
     * @param height the height of the QR code image in pixels
     * @throws WriterException if encoding fails
     * @throws IOException if file writing fails
     */
    private static void generateQRCode(String qrCodeToBeGeneratedURL, String pathToSaveQRCodes, int width, int height) throws WriterException, IOException {

        BitMatrix bitMatrix = new MultiFormatWriter().encode(qrCodeToBeGeneratedURL, BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToPath(bitMatrix, pathToSaveQRCodes.substring(pathToSaveQRCodes.lastIndexOf(".")+1), Paths.get(pathToSaveQRCodes));
    }

}