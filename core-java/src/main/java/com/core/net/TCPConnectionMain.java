package com.core.net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

public class TCPConnectionMain {

    public static void main(String[] args) {

        String hostname = "10.244.16.82";
        int port = 22447;

        try (Socket socket = new Socket(hostname, port)) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            byte[] bytes1 = new byte[] {0x00,0x43,0x00,0x00,0x02,0x00,0x70,0x38,0x00,0x01,0x00,(byte)0xC0,(byte)0x80,0x00,0x13,0x05,0x04,0x32,0x4B,0x00,0x49,0x2A,0x19,0x23,0x0A,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x20,0x3E,0x0B,0x20,0x2C,0x0B,0x20,0x2C,0x06,0x09,0x7A,0x32,0x46,0x02,0x31,0x37,0x31,0x20,0x20,0x20,0x20,0x20,0x30,0x30,0x30,0x30,0x30,0x30,0x33,0x33,0x37,0x38,0x30,0x30,0x30,0x30,0x30,0x08,0x1A};

            byte[] bytes = new byte[] { 0x00, 0x43, 0x00, 0x00, 0x02, 0x00, 0x70, 0x38, 0x00, 0x01, 0x00, (byte) 0xC0,
                    (byte) 0x80, 0x00, 0x13, 0x05, 0x04, 0x50, 0x75, 0x00, 0x74, 0x01, (byte) 0x99, (byte) 0x84, 0x01,
                    0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x18, 0x67, 0x10, 0x11, 0x29, 0x10, 0x11, 0x29, 0x01,
                    0x31, 0x06, 0x50, 0x70, 0x02, 0x38, 0x31, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x30, 0x30, 0x30,
                    0x30, 0x30, 0x30, 0x34, 0x30, 0x35, 0x38, 0x30, 0x30, 0x30, 0x30, 0x30, 0x08, 0x26, (byte) 0xFF };

            out.write(bytes);
            System.out.println("Sent:" + Arrays.toString(bytes));

            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);

            int character;
            StringBuilder data = new StringBuilder();

            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte buffer[] = new byte[65533];// 65533
            try {
                // takes input from socket

                InputStream in = new DataInputStream(socket.getInputStream());
                InputStreamReader readerNew = new InputStreamReader(in);
                Integer c = 0;
                System.out.println(new Date());
                Long ct = 0L;
                while (ct < 100000000) {
                    ct++;
                }

                while (readerNew.ready()) {
                    c = readerNew.read();
                    baos.write(buffer, 0, c);
                    //data.append((char) c);
                    System.out.print(c);
                }
                socket.close();
                System.out.println();
                System.out.println(new Date());

//                System.out.println("Response ByteArray : " + Arrays.toString(baos.toByteArray()));
//                System.out.println("Response : " + bytesToHex(baos.toByteArray()));

            } catch (IOException e) {
                System.out.println(e);
                // LOG.error("Exception while receiving data from SVR socker {}", e);
            }

            // System.out.println("received:" + baos.toByteArray());

        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}