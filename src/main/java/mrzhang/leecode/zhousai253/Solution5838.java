package mrzhang.leecode.zhousai253;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/8
 */
public class Solution5838 {

	public static void main(String[] args) {

	}

	public static boolean isPrefixString(String s, String[] words) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			if (s.indexOf(words[i]) < -1) {
				return false;
			}

			// 从i - j 组成的字符串sb == s, 直接return true；
			// else if 不包含 return false
			// else 继续
			sb.append(words[i]);
			if (s.equals(sb.toString())) {
				return true;
			} else if (s.indexOf(sb.toString()) < -1) {
				return false;
			} else {
				continue;
			}
		}

		return false;
	}

}
