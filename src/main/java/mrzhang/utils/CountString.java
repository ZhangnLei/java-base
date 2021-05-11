package mrzhang.utils;

import com.sun.media.sound.SoftTuning;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author zhangnianlei
 * @date 2020/12/28
 */
public class CountString {
//	public static void main(String[] args) {
//		String a = "张念磊我是";
//		String b = "张念磊";
//
//		System.out.println(strCount(a, b));
//	}


	/**
	 *
	 * @param str 源字符串
	 * @param findByStr 被查询的字符串
	 * @return 返回findByStr在str中出现的次数
	 */
	public static int strCount(String str,String findByStr){
		String[] split = str.split("");
		return Arrays.asList(split).stream().filter(s -> s.equals(findByStr)).collect(Collectors.toList()).size();
	}


	public static void main(String[] args)
	{
		String str="张念磊我是";
		String substr="张念磊";
		sop(stringsub(str,substr));
		System.out.println("Hello World!");



		String fileName = "1报表.docx";
		fileName = fileName.replace(".docx", "");
		fileName = fileName.replace(".doc", "");
		System.out.println(fileName);
	}

	public static int stringsub(String str,String substr)
	{
		int index=0;
		int count=0;
		int fromindex=0;
		while((index=str.indexOf(substr,fromindex))!=-1)
		{
			//str=str.substring(index+substr.length());
			fromindex=index+substr.length();
			count++;
		}
		return count;
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}


}
