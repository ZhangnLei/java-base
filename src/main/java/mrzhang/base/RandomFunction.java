package mrzhang.base;

/**
 * @author zhangnianlei
 * @create 2019/9/19.
 * @description 随机生成30-60之间的随机数
 */
public class RandomFunction {
    public static void main(String[] args) {
        Integer num = 30 + (int) (Math.random()*30);
        System.out.println(num);
    }
}
