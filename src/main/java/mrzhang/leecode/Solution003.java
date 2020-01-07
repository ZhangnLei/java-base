package mrzhang.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangnianlei
 * @date 2019/10/23
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution003 {

	/**
	 * @description 暴力法
	 * 首先找出字符串的所有子串，然后判断子串是否有重复的子串，如果没有则比较最大值
	 * 分为两步：
	 *  1. 找出所有的子串
	 *  2. 判断是否有重复
	 * @author zhangnianlei
	 * @date 2020/1/7
	 * @exception
	 * @param: s
	 * @return: int
	 * @modifier
	 */
	public static int lengthOfLongestSubstringViolence(String s) {
		int max = 0;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				String substring = s.substring(i, j);
				if (isNoRepeatedStrings(substring)){
					max = Math.max(max, substring.length());
				}
			}
		}
		return max;
	}

	/**
	 * @description 判断字符串是否有重复的字符
	 * @author zhangnianlei
	 * @date 2020/1/7
	 * @exception
	 * @param: s
	 * @return: boolean
	 * @modifier
	 */
	public static boolean isNoRepeatedStrings(String s){
		boolean is = true;
		Set<String> set = new HashSet<>(s.length());
		String[] split = s.split("");
		for (String s1 : split) {
			if (set.contains(s1)){
				is = false;
				break;
			}else {
				set.add(s1);
			}
		}
		return is;
	}

	/**
	 * @description
	 * 使用滑动窗口
	 * 	其中i为窗口的最左端，j为最右端，左闭右开(j不在窗口中)
	 * 	如果发现第J个字符在窗口中存在，则窗口的左端i移动到当前j的位置
	 * 			记录当前的最大值
	 * @author zhangnianlei
	 * @date 2020/1/7
	 * @exception
	 * @modifier
	 */

	public static int lengthOfLongestSubstring(String s){
		int max = 0;//定义最长长度，默认值为0
		//定义hashmap，存放滑动窗口信息
		Map<Character, Integer> map = new HashMap<>();
		//for循环遍历，其中i为窗口的最左端，j为最右端，左闭右开(j不在窗口中)
		for (int i = 0, j = 0; j < s.length(); j++) {
			//如果发现第J个字符在窗口中存在，则窗口的左端i移动到当前j的位置
			if (map.containsKey(s.charAt(j))){
				i = Math.max(map.get(s.charAt(j)), i);
			}
			//判断当前的窗口长度是否为最大值，如果是则更新最大值
			max = Math.max(max, j-i+1);
			//将当前j存入hashmap中，为下一轮的判断做准备
			map.put(s.charAt(j), j+1);
		}
		return max;
	}


	public static void main(String[] args) {
		String s = "adda";
//		String s = "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		long startTime=System.currentTimeMillis();   //获取开始时间

//		System.out.println(lengthOfLongestSubstringViolence(s));
		System.out.println(lengthOfLongestSubstring(s));

		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");


	}
}
