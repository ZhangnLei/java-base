package mrzhang.utils;

import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangnianlei
 * @date 2020/4/13
 */
public class PatternUtils {
	// 正则表达式判断数字
	public static boolean isNumeric(String str){
		String rules = "[0-9]*";
		Pattern pattern = Pattern.compile(rules);
		return pattern.matcher(str).matches();
	}

//	public static void main(String[] args) {
////		System.out.println(isNumeric("hello"));
////		System.out.println(isNumeric("12354"));
////		System.out.println(isNumeric(null));
//
///**
// * text/html ： HTML格式
// *     text/plain ：纯文本格式
// *     text/xml ：  XML格式
// *     image/gif ：gif图片格式
// *     image/jpeg ：jpg图片格式
// *     image/png：png图片格式
// *
// *      application/xhtml+xml ：XHTML格式
// *    application/xml     ： XML数据格式
// *    application/atom+xml  ：Atom XML聚合格式
// *    application/json    ： JSON数据格式
// *    application/pdf       ：pdf格式
// *    application/msword  ： Word文档格式
// *    application/octet-stream ： 二进制流数据（如常见的文件下载）
// */
//		System.out.println(getContentType("asdfasdf.jpg"));
//		System.out.println(getContentType("asdfasdf.png"));
//		System.out.println(getContentType("asdfasdf.pdf"));
//		System.out.println(getContentType("asdfasdf.gif"));
//		System.out.println(getContentType("asdfasdf.doc"));
//		System.out.println(getContentType("asdfasdf.abc"));
//	}

	/**
	 * @description 根据文件路径获取需要返回浏览器的ContentType
	 * @author zhangnianlei
	 * @date 2020/4/22
	 * @exception
	 * @param: fileUrl
	 * @return: java.lang.String
	 * @modifier
	 */
	public static String getContentType(String fileUrl) {
		// 获取文件后缀名
		String fileType = fileUrl.substring(fileUrl.lastIndexOf(".")+1);
		Map<String, String> typeMap = new HashMap<>();
		typeMap.put("gif", "image/gif");
		typeMap.put("jpg", "image/jpeg");
		typeMap.put("png", "image/png");
		typeMap.put("png", "application/x-png");
		typeMap.put("pdf", "application/pdf");
		typeMap.put("jpg", "image/jpeg");
		typeMap.put("doc", "application/msword");
		typeMap.put("docx", "application/msword");
		typeMap.put("*", "application/octet-stream");
		return null == typeMap.get(fileType) ? typeMap.get("*") : typeMap.get(fileType);
	}



	/**
	 * @description 判断字符串是否为正确的时间格式
	 * @author zhangnianlei
	 * @date 2020/4/30
	 * @exception
	 * @param: date
	 * @return: boolean
	 * @modifier
	 */
	public static boolean checkDate(String date) {
		System.out.println(date);
		if (StringUtils.isBlank(date)) {
			date = "change";
			return true;
		}
		boolean b = false;
		try {
			LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			b = true;
		} catch (Exception e) {
			b = false;
		}
		if (!b) {
			try {
				LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				b = true;
			} catch (Exception e) {
				b = false;

			}
			return b;
		}
		return b;
	}

	public static void main(String[] args) {
// TODO Auto-generated method stub
		String str = "2001-01";
		System.out.println(checkDate(str));
		System.out.println(str);
//		checkDate("2009-1-1");
//		checkDate("2009/01/01");
//		checkDate("2009/1/1");
//		checkDate("2009/13/01");

	}

}
