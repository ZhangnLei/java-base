package mrzhang.leecode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangnianlei
 * @date 2020/11/6
 */
public class Solution1356 {

	public static void main(String[] args) {
		int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
		int[] res = sortByBits(arr);
		System.out.println(JSON.toJSONString(res));
	}


	public static int[] sortByBits(int[] arr) {
		int[] bit = new int[10001];
		List<Integer> list = new ArrayList<Integer>();
		for (int x : arr) {
			list.add(x);
			bit[x] = get(x);
		}
		Collections.sort(list, (x, y) -> { return bit[x] != bit[y] ? bit[x] - bit[y] : x - y; });
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static int get(int x) {
		int res = 0;
		while (x != 0) {
			res += x % 2;
			x /= 2;
		}
		return res;
	}

}
