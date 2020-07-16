package mrzhang.sy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author zhangnianlei
 * @date 2020/7/15
 */
public class ReflectionTest {
	public static void main(String[] args) {
		Field[] clzFields = getAllFields(AppSysUnitVo.class);
//		Field[] clzFields = AppSysUnitVo.class.getDeclaredFields();
		List<AppSysUnitVo> list = new ArrayList<>();
		list.add(new AppSysUnitVo("BJSY", "123"));
		list.add(new AppSysUnitVo("BJSY", "124"));

		List<Map<String, Object>> exportList = new ArrayList<>();

		for(AppSysUnitVo vo: list) {

			Map<String, Object> map = new HashMap<>();
			for (Field clzField : clzFields) {
				try {
					if (!clzField.isAccessible()) {
						clzField.setAccessible(true);
					}
					System.out.println(clzField.getName());
					map.put(clzField.getName(), clzField.get(vo));
				} catch (Exception e) {
					e.printStackTrace();
				}
				exportList.add(map);
			}
		}
		System.out.println(JSON.toJSONString(exportList, SerializerFeature.DisableCircularReferenceDetect));
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
