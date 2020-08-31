package mrzhang.base;

import java.util.HashMap;

/**
 * @author zhangnianlei
 * @date 2020/8/21
 */
public class HashMapResolve {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		HashMap map1 = new HashMap(10);
		HashMap map2 = new HashMap(10, 0.8f);

		System.out.println(map.size());
		System.out.println(map1.size());
		System.out.println(map2.size());
		
		String hello= "hello";
		if (hello.equalsIgnoreCase("helloworld"));
	}
}
