package com.example.demo.qcr.tools;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 16进制字符串 与 byte数组 相互转换工具类
 */
public class HexUtils {

    private static final char[] HEXES = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f'
    };

    /**
     * byte数组 转换成 16进制小写字符串
     */
    public static String bytes2Hex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        StringBuilder hex = new StringBuilder();

        for (byte b : bytes) {
            hex.append(HEXES[(b >> 4) & 0x0F]);
            hex.append(HEXES[b & 0x0F]);
        }

        return hex.toString();
    }

    /**
     * 16进制字符串 转换为对应的 byte数组
     */
    public static byte[] hex2Bytes(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }

        char[] hexChars = hex.toCharArray();
        byte[] bytes = new byte[hexChars.length / 2];   // 如果 hex 中的字符不是偶数个, 则忽略最后一个

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt("" + hexChars[i * 2] + hexChars[i * 2 + 1], 16);
        }

        return bytes;
    }
    
    /**
     * byte数组 转换为 Base64字符串
     */
    public static String encode(byte[] data) {
        return new BASE64Encoder().encode(data);
    }

    /**
     * Base64字符串 转换为 byte数组
     */
    public static byte[] decode(String base64) {
        try {
            return new BASE64Decoder().decodeBuffer(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * 把文件内容编码为 Base64字符串, 只能编码小文件（例如文本、图片等）
     */
    public static String encodeFile(File file) throws Exception {
        InputStream in = null;
        ByteArrayOutputStream bytesOut = null;

        try {
            in = new FileInputStream(file);
            bytesOut = new ByteArrayOutputStream((int) file.length());

            byte[] buf = new byte[1024];
            int len = -1;

            while ((len = in.read(buf)) != -1) {
                bytesOut.write(buf, 0, len);
            }
            bytesOut.flush();

            return encode(bytesOut.toByteArray());

        } finally {
            close(in);
            close(bytesOut);
        }
    }

    /**
     * 把 Base64字符串 转换为 byte数组, 保存到指定文件
     */
    public static void decodeFile(String base64, File file) throws Exception {
        OutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(file);
            fileOut.write(decode(base64));
            fileOut.flush();
        } finally {
            close(fileOut);
        }
    }

    private static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                // nothing
            }
        }
    }

}
