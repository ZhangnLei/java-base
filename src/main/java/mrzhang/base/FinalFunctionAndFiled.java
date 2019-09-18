package mrzhang.base;

/**
 * @author zhangnianlei
 * @create 2019/9/19.
 * @description 被final修饰的方法可以被重载，变量不能修改
 */
public class FinalFunctionAndFiled {
    public final String var1= "zhang";
    public final String func1() {
        return "hello";
    }

    public void func1(String hello){
//        var1 = 2;
        return;
    }
}
