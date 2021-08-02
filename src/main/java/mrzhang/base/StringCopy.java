package mrzhang.base;

import java.util.Arrays;

public class StringCopy {


    public static void main(String[] args) {

        String str = "A";
        String asciiResult = stringToAscii(str);
        System.out.println(asciiResult);
        String stringResult = asciiToString(asciiResult);
        System.out.println(stringResult);


        System.out.println();
        String asciiNumToString = asciiNumToString(66);
        System.out.println("asciiNumToString:" + asciiNumToString);
    }

    public static String asciiNumToString(int value)
    {
        StringBuffer sbu = new StringBuffer();
        sbu.append((char) value);
        return sbu.toString();
    }

    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }

    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    private static void mergeStringArray() {
        String[] str1 = { "J", "a", "v", "a", "中" };
        String[] str2 = { "如", "何", "把", "两", "个", "数", "组", "合", "并", "为",
                "一", "个" };

        int strLen1 = str1.length;// 保存第一个数组长度
        int strLen2 = str2.length;// 保存第二个数组长度
        str1 = Arrays.copyOf(str1, strLen1 + strLen2);// 扩容
        System.arraycopy(str2, 0, str1, strLen1, strLen2);// 将第二个数组与第一个数组合并
        System.out.println(Arrays.toString(str1));// 输出数组
    }
}
