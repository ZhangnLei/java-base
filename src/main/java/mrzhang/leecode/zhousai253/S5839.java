package mrzhang.leecode.zhousai253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/8
 */
public class S5839 {


	/**
	 * @throws
	 * @description 思路一 暴力法 超出时间限制
	 * @author zhangnianlei
	 * @date 2021/8/8
	 * @param: piles
	 * @param: k
	 * @return: int
	 * @modifier
	 */
	public int minStoneSum1(int[] piles, int k) {
		int length = piles.length;

		while (k > 0) {
			Arrays.sort(piles);
			piles[length - 1] -= Math.floor(piles[length - 1] / 2);
			k--;
		}

		int sum = 0;
		for (int each : piles) {
			sum += each;
		}

		return sum;
	}


	/**
	 * @throws
	 * @description 思路2 使用java的优先队列
	 * @author zhangnianlei
	 * @date 2021/8/8
	 * @param: piles
	 * @param: k
	 * @return: int
	 * @modifier
	 */
	public int minStoneSum(int[] piles, int k) {
		Queue<Integer> queue = new PriorityQueue<>(piles.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int each : piles) {
			queue.add(each);
		}

		while (k > 0) {
			Integer max = queue.poll();
			max = (int) (max - Math.floor(max / 2));
			queue.add(max);
			k--;
		}

		int sum = 0;
		while (! queue.isEmpty()) {
			sum += queue.poll();
		}

		return sum;

	}


}
