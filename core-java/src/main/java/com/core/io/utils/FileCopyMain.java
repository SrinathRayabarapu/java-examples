package com.core.io.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

public class FileCopyMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String inputFile = "InputFile.txt";
        String outputFile = "OutputFile.txt";

        var inputStream = FileCopyMain.class.getClassLoader().getResourceAsStream(inputFile);
        OutputStream outputStream = new FileOutputStream(
                FileCopyMain.class.getClassLoader()
                        .getResource(outputFile)
                        .getFile()
        );

        IOUtils.copy(inputStream, outputStream);

        System.out.println("Copy done!");

        inputStream.close();
        outputStream.close();
    }

}
