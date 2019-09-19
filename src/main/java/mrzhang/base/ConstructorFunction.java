package mrzhang.base;

/**
 * @author zhangnianlei
 * @create 2019/9/19.
 * @description 构造函数的用法
 * java 派生类调用父类含有参数的构造函数时必须使用super
 */
public class ConstructorFunction {

    class Father {
        Father(){
            System.out.println("father");
        }
        Father(int age){
            System.out.println("father is "+age);
        }

    }
    class Son extends Father{
        Son(){
            //子类的构造函数中不显是的调用父类的构造函数则将默认调用父类的无参构造函数
            //调用父类含有参数的构造函数时必须使用super
            super(45);
            System.out.println("son");
        }
    }


    public static void main(String[] args) {
        ConstructorFunction c = new ConstructorFunction();
        c.test();

    }

    private void test() {
        Son son = new Son();
    }
}
