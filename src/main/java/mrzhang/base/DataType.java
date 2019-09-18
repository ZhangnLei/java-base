package mrzhang.base;

/**
 * @author zhangnianlei
 * @create 2019/9/18.
 * @description
 */
public class DataType {

    /* 下面那个语句可以编译通过？ */
//    Short myshort = 99S;
//    float z = 1.0;
//    int t = "abc".length();
//    char c = 97c;
    /**
     * 只有3
     * 1.不可以在short后面加字母
     * 2.float需要在数字后面加f
     * 4.要么char c= 97; 要么 char c = 'c';
     */


    public static void main(String[] args) {
        Iplusplus();
    }

    private static void Iplusplus() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);
    }
    /* 输出结果为0 */

}
