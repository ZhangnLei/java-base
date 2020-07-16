package mrzhang.sy;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author zhangnianlei
 * @date 2020/7/16
 */
public class GetAllAttributesOfClasses {

	public static void main(String[] args) {
		System.out.println("获取类自己的所有的属性 getDeclaredFields");
		getOwnFields();
		System.out.println("获取类自己的所有的public属性 getFields");
		getAllPublic();
		System.out.println("获取类自己的所有的属性 并遍历获取所有父类的属性");
		getAll();
	}


	/**
	 * @description 获取类自己的所有的属性 并遍历获取所有父类的属性
	 * @author zhangnianlei
	 * @date 2020/7/16
	 * @exception
	 * @modifier
	 */
	private static void getAll() {
		Field[] clzFields = getAllFields(AppSysUnitVo.class);
		for (Field clzField : clzFields) {
			try {
				if (!clzField.isAccessible()) {
					clzField.setAccessible(true);
				}
				System.out.println(clzField.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * @description 获取类自己的所有的public属性 getFields
	 * @author zhangnianlei
	 * @date 2020/7/16
	 * @exception
	 * @modifier
	 */
	private static void getAllPublic() {
		Field[] clzFields = AppSysUnitVo.class.getFields();
		for (Field clzField : clzFields) {
			try {
				if (!clzField.isAccessible()) {
					clzField.setAccessible(true);
				}
				System.out.println(clzField.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * @description 获取类自己的所有的属性 getDeclaredFields
	 * @author zhangnianlei
	 * @date 2020/7/16
	 * @exception
	 * @modifier
	 */
	private static void getOwnFields() {
		Field[] clzFields = AppSysUnitVo.class.getDeclaredFields();
		for (Field clzField : clzFields) {
			try {
				if (!clzField.isAccessible()) {
					clzField.setAccessible(true);
				}
				System.out.println(clzField.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取本类及其父类的属性的方法
	 * @param clazz 当前类对象
	 * @return 字段数组
	 */
	private static Field[] getAllFields(Class<?> clazz) {
		List<Field> fieldList = new ArrayList<>();
		while (clazz != null){
			fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
			clazz = clazz.getSuperclass();
		}
		Field[] fields = new Field[fieldList.size()];
		return fieldList.toArray(fields);
	}

}