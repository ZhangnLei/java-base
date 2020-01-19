package mrzhang.utils;

import java.util.*;

/**
 * 获取字符的出现频率
 * @author zhangnianlei
 * @date 2020/1/18
 */
public class StringFrequency {
	public static void main(String[] args) {
		String s = "fsorcocranb,ay,vlmhnee.wuiwto,”d.ulHOUPOhe”R,niysoFfo";
		getFrequency(s);
	}

	private static void getFrequency(String s) {
		Map<String, Integer> map = new HashMap<>(s.length());
		for (String s1 : s.split("")) {
			if (map.containsKey(s1)){
				map.put(s1, map.get(s1) + 1);
			}else {
				map.put(s1, 1);
			}
		}
		sortMap(map);
	}

	static void sortMap(Map<String, Integer> map){
		List<Map.Entry<String, Integer>> listMap = new ArrayList<>();
		listMap.addAll(map.entrySet());
		Collections.sort(listMap, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		listMap.forEach(System.out::println);
	}
}
