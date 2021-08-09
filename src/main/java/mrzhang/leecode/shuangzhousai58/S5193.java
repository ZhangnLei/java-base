package mrzhang.leecode.shuangzhousai58;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/8
 */
public class S5193 {


	public static void main(String[] args) {
		String string = makeFancyString("leeetcode");
		System.out.println(string);
	}


	public static String makeFancyString(String s) {

		StringBuilder sb = new StringBuilder(s);
		int count = 0;
		char lastChar = ' ';
		for (int i = s.length() - 1; i >= 0; i--) {
			if (count >= 2 && s.charAt(i) == lastChar) {
				sb.deleteCharAt(i);
			} else if (s.charAt(i) == lastChar){
				count ++;
			} else if (s.charAt(i) != lastChar) {
				count = 1;
				lastChar = s.charAt(i);
			}
		}

		return sb.toString();
	}

}
