package com.core.bytes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ImageToByteArrayAndBackToImage {

    public static void main(String[] args) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(new File("/Users/srinathr/git-personal/java-practice/core-java/src/main/resources/MyPhoto.jpg"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        System.out.println(Arrays.toString(bytes));
        System.out.println(bytes.length);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage1 = ImageIO.read(byteArrayInputStream);
        ImageIO.write(bufferedImage1, "jpg", new File("/Users/srinathr/git-personal/java-practice/core-java/src/main/resources/MyPhotoCopy.jpg"));

        System.out.println("New Image copy created");
    }
}