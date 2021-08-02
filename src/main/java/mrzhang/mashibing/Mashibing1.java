package mrzhang.mashibing;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhangnianlei
 * @create 2020/10/18.
 * @description
 */
public class Mashibing1 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
