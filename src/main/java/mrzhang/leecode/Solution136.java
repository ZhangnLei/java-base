package mrzhang.leecode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author zhangnianlei
 * @date 2020/5/14
 */
public class Solution136 {
	public static int singleNumber(int[] nums) {
		// 1. 把数组放进map中
		Map<Integer, Integer> map = new TreeMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		System.out.println(JSON.toJSONString(map));
		// 2. 排序
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		System.out.println(JSON.toJSONString(list));

		// 3. 找到那个只有一个的数字
		return list.get(0).getKey();
	}


	public static void main(String[] args) {
		int[] nums = {2,2,1,2,1,2,3,4,5,5,4,4,3,2,2,2,2,3,4,4,4,9};
		int i = singleNumber(nums);
		System.out.println(i);
	}
}