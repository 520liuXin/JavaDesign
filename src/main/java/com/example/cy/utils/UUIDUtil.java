package com.example.cy.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.UUID;

/**
 *
 * @author Dreamhai
 * @Date 2018-06-08
 * UUID工具类
 */
public class UUIDUtil {
    private static final String[] chars = new String[]{"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * 返回22位无重复UUID串
     *
     * @return uid
     */
    public static String getUid() {
        return getUUIDStr();
    }

    /**
     * 返回前缀+22位无重复UUID串
     *
     * @param prefix 前缀
     * @return pre + uid
     */
    public static String getUid(String prefix) {
        return prefix + getUUIDStr();
    }

    /**
     * 返回前缀+指定长度无重复UUID串
     * @param prefix
     * @param Length
     * @return
     */
    public static String getUid(String prefix , int Length){
        return prefix+getUUIDByLength(Length);
    }

    /**
     * 返回8位短UUID串
     *
     * @return uid
     */
    public static String getShortUid() {
        StringBuilder shortBuffer = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    /**
     * 返回一个指定长度的 UUId字符串
     * @param length
     * @return
     */
    public static String getUUIDByLength(int length) {
        if (length < 1) {
            return null;
        }
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i <= (length / 22); i++) {
            sBuffer.append(getUid());
        }
        //截取 length 长度
        return sBuffer.toString().substring(0,length);
    }


    private static BigInteger unsigned2BigInt(long value) {
        if (value >= 0)
            return BigInteger.valueOf(value);

        // 将value 转 无符号数
        long lowValue = value & 0x7fffffffffffffffL;
        return BigInteger.valueOf(lowValue).
                add(BigInteger.valueOf(Long.MAX_VALUE)).
                add(BigInteger.valueOf(1));
    }

    /**
     * 获取UUID字符串
     * @return
     */
    private static String getUUIDStr() {
        UUID uuid = UUID.randomUUID();
        BigInteger pt1 = unsigned2BigInt(uuid.getMostSignificantBits());
        BigInteger pt2 = unsigned2BigInt(uuid.getLeastSignificantBits());

        StringBuilder sb = new StringBuilder();
        while (pt1.longValue() != 0) {
            BigInteger[] s = pt1.divideAndRemainder(BigInteger.valueOf(chars.length));
            sb.append(chars[s[1].intValue()]);
            pt1 = s[0];
        }
        sb.append(StringUtils.repeat(chars[0], 11 - sb.length()));
        while (pt2.longValue() != 0) {
            BigInteger[] s = pt2.divideAndRemainder(BigInteger.valueOf(chars.length));
            sb.append(chars[s[1].intValue()]);
            pt2 = s[0];
        }
        sb.append(StringUtils.repeat(chars[0], 22 - sb.length()));
        return StringUtils.reverse(sb.toString());
    }


}
