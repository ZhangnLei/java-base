package mrzhang.base;

import java.util.ArrayList;

/**
 * @author zhangnianlei
 * @create 2019/9/19.
 * @description 字符串常量池
 */
public class StringConstantPool {
    public static void main(String[] args) throws Exception{
        String st1 = "abc";
        System.out.println("abc" == st1);
        //true

        String st2 = "abc";
        System.out.println(st2.equals(new String("abc")));
        //true

        Integer i1 = 100;
        System.out.println(100 == i1);
        //true

        ArrayList list = new ArrayList();
        System.out.println(list.contains(null));
        //false

        int a = 5;
        System.out.println("value is "+ ((a <= 5) ? 10L:9f));

        int i = 12;
        System.out.println(i += i -= i *= i);
    }

}
