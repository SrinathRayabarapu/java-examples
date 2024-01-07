package com.core.io.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Util class for File IO operations
 */
public class IOUtils {

    /**
     * reads content from {@link InputStream} and writes to {@link OutputStream}
     *
     * @param inputStream
     * @param outputStream
     * @throws IOException
     */
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        int value;
        while ((value = inputStream.read()) != -1) { // reading till end of the file
            outputStream.write(value);
        }
    }

}
