package mrzhang.utils;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangnianlei
 * @date 2020/4/23
 */
public class Base64ForPic {



	/**
	 * @description 文件（图片、excel等）转换成Base64字符串
	 * @author zhangnianlei
	 * @date 2020/4/23
	 * @exception
	 * @param: fileType
	 * @param: imgPath
	 * @return: java.lang.String
	 * @modifier
	 */
	public static String convertFileToBase64(String fileType, String imgPath) {
		byte[] data = null;
		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgPath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组进行Base64编码，得到Base64编码的字符串
		BASE64Encoder encoder = new BASE64Encoder();
		StringBuilder sb = new StringBuilder("data:");
		sb.append(fileType);
		sb.append(";base64,");
		sb.append(encoder.encode(data));
		return sb.toString();
	}


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
		String fileType = fileUrl.substring(fileUrl.lastIndexOf(".") + 1);
		Map<String, String> typeMap = new HashMap<>();
		typeMap.put("gif", "image/gif");
		typeMap.put("jpg", "image/jpeg");
		typeMap.put("png", "image/png");
		typeMap.put("doc", "application/msword");
		typeMap.put("docx", "application/msword");
		return null == typeMap.get(fileType) ? typeMap.get("png") : typeMap.get(fileType);
	}


	public static void main(String[] args) {
		System.out.println(convertFileToBase64(getContentType("/Users/zhangdabao/Pictures/blog/zhangdabao.jpg"), "/Users/zhangdabao/Pictures/blog/zhangdabao.jpg"));
	}
}
