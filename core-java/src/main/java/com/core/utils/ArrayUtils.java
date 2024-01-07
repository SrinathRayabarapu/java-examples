package com.core.utils;

//import com.google.common.primitives.Bytes;

import java.lang.reflect.Array;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

//    public static boolean contains(byte[] array, byte find) {
//        return Bytes.contains(array, find);
//    }
//
//    public static byte[] toPrimitive(List<Byte> data) {
//        return Bytes.toArray(data);
//    }
//
//    public static Byte[] toObject(byte[] data) {
//        return org.apache.commons.lang.ArrayUtils.toObject(data);
//    }
//
//    public static byte[] concatenate(byte[] a, byte[] b) {
//        return Bytes.concat(a, b);
//    }

    public static byte[] skip(byte[] src, int numberOfBytesToSkip) {
        int noBytesToCopy = Math.max(src.length - Math.max(numberOfBytesToSkip, 0), 0);
        byte[] dest = new byte[noBytesToCopy];
        if (noBytesToCopy > 0)
            System.arraycopy(src, numberOfBytesToSkip, dest, 0, noBytesToCopy);
        return dest;
    }

    public static byte[] take(byte[] src, int length) {
        byte[] dest = new byte[length];
        System.arraycopy(src, 0, dest, 0, length);
        return dest;
    }

    public static byte last(byte[] data) {
        return data[data.length - 1];
    }

    public static byte[] bytes(int... ints) {
        byte[] bytes = new byte[ints.length];
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte) ints[i];
        }
        return bytes;
    }


    public static byte[] getBytes(int value) {
        byte[] data = new byte[2];
        data[1] = (byte) (value & 0xFF);
        data[0] = (byte) ((value >> 8) & 0xFF);
        return data;
    }

    public static byte[] intToBytes(final int data) {
        return new byte[]{
                (byte) ((data >> 24) & 0xff),
                (byte) ((data >> 16) & 0xff),
                (byte) ((data >> 8) & 0xff),
                (byte) (data & 0xff),
        };
    }

    public static int bytesToInt(byte[] bytes) {
        int result = 0;

        if(bytes.length > 4)
            throw new RuntimeException("Too big to fit in int");

        for (byte aByte : bytes) {
            result = result << 8;
            result = result | (aByte & 0xFF);
        }
        return result;
    }

    public static boolean isBitSet(int number, int bitPosition) {
        return ((number >> (bitPosition)) & 1) > 0;
    }

//    public static byte[] trimLeadingZeros(byte[] bytes) {
//        return ArrayUtils.toPrimitive(
//                Arrays.stream(ArrayUtils.toObject(bytes))
//                        .dropWhile(aByte -> aByte == 0x00)
//                        .collect(Collectors.toList()));
//    }

}