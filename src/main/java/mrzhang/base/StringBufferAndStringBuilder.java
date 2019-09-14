package mrzhang.base;

/**
 * @author zhangnianlei
 * @create 14/09/2019.
 * @description StringBuffer和StringBuilder的区别
 */
public class StringBufferAndStringBuilder {

    /**
     * string类的不变性是因为使用private final char value[]；
     * stringbuffer与stringbuilder可变性，继承AbstractStringBuffer类，AbstractStringBuffer使用char value[] ；
     * 查看源码发现stringbuffer类使用synchronize修饰大多数的方法以保证线程安全
     */
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
    }
}
