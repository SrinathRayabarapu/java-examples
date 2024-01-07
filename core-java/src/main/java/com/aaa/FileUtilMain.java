package com.aaa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileUtilMain {
    public static void main(String[] args) throws IOException {
//        FileUtil.createDestinationDirectory("/Users/srinathr/testfolder");
//        FileUtil.copyDirectory("testfolder", "/Users/srinathr/testfolder1");

//        String abc = "/dev/ttyS0";
//        System.out.println(abc.split("/").length);

//        readPCDToolReturnCodeFromFile("/Users/srinathr/result.log");

        int i = readPCDToolReturnCodeFromFile1("/Users/srinathr/result.log");
        System.out.println("i = " + i);

    }

    private static int readPCDToolReturnCodeFromFile(String ingenicoToolsDestinationPath) throws FileNotFoundException {
        File resultFile = new File(ingenicoToolsDestinationPath);
        String lastLine = null;
        try (Scanner myReader = new Scanner(resultFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data != null && data.trim().length() > 0){
                    lastLine = data;
                }
                System.out.println("data : " + data);
                if (!myReader.hasNextLine()) {
                    System.out.println("PCDTool Result : " + lastLine);
                    return Integer.decode(lastLine.split(",")[1]);
                }
            }
        }
        return 0;
    }

    private static int readPCDToolReturnCodeFromFile1(String ingenicoToolsDestinationPath) throws IOException {
//        if(exitValue == 0){
            File resultFile = new File(ingenicoToolsDestinationPath);
            try (Scanner myReader = new Scanner(resultFile)) {
                while (myReader.hasNextLine()) {
                    String nextLine = myReader.nextLine();
                    if (nextLine != null && "Download completed successfully".equalsIgnoreCase(nextLine.trim())) {
//                        FileUtil.deleteFile(ingenicoToolsDestinationPath + LINUX_PCD_TOOL_FOLDER + File.separator + "result.log");
                        return 9000;
                    }
                }
            }
//        }
        return 0;
    }
}
