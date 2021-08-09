package mrzhang.leecode.zhousai253;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/8
 */
public class S5840 {

	public int minSwaps1(String s) {
		int times = 0;

		// 中心扩散法

		String[] word = s.split("");
		int length = word.length;
		int i = length / 2;
		int j = i + 1;
		while (i >= 0) {

		}

		return times;
	}


	/**
	 * @throws
	 * @description 字符串每个位置的开括号数目一定大于等于闭括号数目：left >= right
	 * @author zhangnianlei
	 * @date 2021/8/8
	 * @param: s
	 * @return: int
	 * @modifier
	 */
	public int minSwaps(String s) {
		int times = 0;
		int left = 0, right = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				left ++;
			} else {
				right ++;
			}

			if (right > left) {
				times ++;
				left ++;
				right --;
			}
		}

		return times;
	}


}
