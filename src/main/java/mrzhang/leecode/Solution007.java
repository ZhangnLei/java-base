package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2019/10/16
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution007 {
	public int reverse001(int i){
		long res = 0;
		while (i != 0) {
			res = res * 10 + i % 10;
			i = i / 10;
		}
		return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int)res;
	}

	public int reverse1(int x) {
		Boolean isNegative = false;//是否为负数
		if (x < 0){
			isNegative = true;
			x = -x;
		}
		String str = Integer.valueOf(x).toString();
		String[] strings = str.split("");
		StringBuilder sb = new StringBuilder();
		//反转字符串
		for (int i = strings.length - 1; i >= 0; i--) {
			sb.append(strings[i]);
		}
		int result = Integer.valueOf(sb.toString());
		result = isNegative ? -result : result;
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
			return 0;
		}
		return result;
	}

	public static int reverse(int x) {
		int result = 0;

		while (x != 0) {
			// x % 10 可以取到 x 最后一位的值，即此时 pop 是 x 的最后一位，也就是新值的第一位
			int pop = x % 10;
			// x 的位数少了最后一位
			x = x / 10;

			// 由于后续运算 result = result * 10 + pop
			// 如果 result 的值大于 Integer.MAX_VALUE / 10 ，那么一定会溢出
			// 如果 result 的值等于 Integer.MAX_VALUE / 10，那么 pop 的值如果大于 Integer.MAX_VALUE % 10 也会溢出
			// 相反的，result 的值小于 Integer.MIN_VALUE / 10 ，那么一定会溢出
			// 如果 result 的值等于 Integer.MIN_VALUE / 10，那么 pop 的值如果小于于 Integer.MIN_VALUE % 10 也会溢出

			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
				result = 0;
				return result;
			} else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
				result = 0;
				return result;
			}

			result = result * 10 + pop;
		}
		return result;
	}

	public static int reverse3(int x) {
		long rs = 0;
		while(x != 0){
			rs = rs*10+x%10;
			x /= 10;
		}
		return (rs<Integer.MIN_VALUE || rs>Integer.MAX_VALUE) ? 0:(int)rs;
	}

	public static void main(String[] args) {
		int a = reverse3( 964632435);
		System.out.println(a);
	}

}
