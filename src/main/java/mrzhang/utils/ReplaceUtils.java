package mrzhang.utils;

/**
 * @author zhangnianlei
 * @date 2021/2/25
 */
public class ReplaceUtils {


	public static void main(String[] args) {
		String fileName = "1报表.xlsx";
		fileName = fileName.replace(".docx", "");
		fileName = fileName.replace(".doc", "");
		fileName = fileName.replace(".xlsx", "");
		fileName = fileName.replace(".xls", "");


		System.out.println(fileName);
	}
}
