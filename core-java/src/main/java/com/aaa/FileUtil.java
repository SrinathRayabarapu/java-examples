package com.aaa;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Slf4j
public class FileUtil {

    public static void setExecutablePermission(String exeLocation) {
        File file = new File(exeLocation);
        log.info("Exe location exists : {}", file.exists());
        log.info("File is : file.canExecute() : {} file.getAbsolutePath() : {}", file.canExecute(), file.getAbsolutePath());
        if (file.exists()) {
            boolean bval = file.setExecutable(true, false);
            log.info("Set permission for executing : " + bval);
        }
    }

    public static void createDestinationDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()){
            boolean result = directory.mkdir();
            log.info("Destination directory :{} created. Result : {}",directoryName,result);
        }
    }

    public static void copyTmsExeToFileSystem(String source, String destination) throws IOException {
        InputStream is = FileUtil.class.getClassLoader().getResourceAsStream(source);
        File tmsExeFile = new File(destination);
        FileOutputStream fos = new FileOutputStream(tmsExeFile);
        byte bytes[] = new byte[1000];
        int k = 0;
        while((k = is.read(bytes)) != -1){
            fos.write(bytes, 0, k);
        }
        fos.close();
    }

    public static void copyDirectory(String source, String destination) throws IOException {
        URL sourceURL = FileUtil.class.getClassLoader().getResource(source);
        File sourceDir = new File(sourceURL.getFile());
        File destinationDir = new File(destination);
        log.info("Copying from source directory : {} to destination directory : {}",
                sourceDir.getAbsolutePath(),
                destinationDir.getAbsolutePath());
        FileUtils.copyDirectory(sourceDir, destinationDir);
        log.info("Directory copied!");
    }

}
