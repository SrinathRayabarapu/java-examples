package com.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public final class HexUtils {

    private final static Logger log = LoggerFactory.getLogger(HexUtils.class);
    public static String formatHexDump(byte[] array) {
        return formatHexDump(array, 0, array.length);
    }

    public static String formatHexSimple(byte[] bytes) {
        if(bytes == null) {
            if (log.isDebugEnabled()) {
                log.debug("HexUtils formatHexSimple is NULL");
            }
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("0x%02X,", b));
        }

        if(sb.toString().isEmpty() || sb.toString().isBlank())
            return sb.toString();

        return sb.substring(0,sb.toString().length()-1);
    }

    public static String formatToHex(byte[] bytes) {
        if(bytes == null) {
            if (log.isDebugEnabled()) {
                log.debug("HexUtils formatHexSimple is NULL");
            }
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    public static String formatHexDump(byte[] array, int offset, int length) {
        final int width = 16;

        StringBuilder builder = new StringBuilder();

        for (int rowOffset = offset; rowOffset < offset + length; rowOffset += width) {
            builder.append(String.format("%06d:  ", rowOffset));

            for (int index = 0; index < width; index++) {
                if (rowOffset + index < array.length) {
                    builder.append(String.format("%02x ", array[rowOffset + index]));
                } else {
                    builder.append("   ");
                }
            }

            if (rowOffset < array.length) {
                int asciiWidth = Math.min(width, array.length - rowOffset);
                builder.append("  |  ");
                builder.append(new String(array, rowOffset, asciiWidth, StandardCharsets.UTF_8).replaceAll("\r\n", " ").replaceAll("\n", " "));
            }

            builder.append(String.format("%n"));
        }

        return builder.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        s = s.replace("\\x", "").replace("0x", "").replace(",", "");
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}