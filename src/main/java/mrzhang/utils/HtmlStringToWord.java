package mrzhang.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.spire.doc.*;
import java.io.*;
/**
 * @author zhangnianlei
 * @date 2021/2/24
 */
public class HtmlStringToWord {

	public static void main(String[] args) throws Exception {

		String filePath = "/Users/zhangdabao/Documents/工作文档/需求专项工具/文档解析测试文档/";

		String fileName = "HTMLstringToWord.docx";

		String inputHtmlFileNameAndPath = "/Users/zhangdabao/Documents/工作文档/需求专项工具/文档解析测试文档/XX银行-需求模板001.html";

		GenerateDocxByHtml(filePath, fileName, inputHtmlFileNameAndPath);
	}


	/**
	 * @description 根据HTML文件生成Word文档
	 * @author zhangnianlei
	 * @date 2021/2/24
	 * @exception
	 * @param: filePath
	 * @param: fileName
	 * @param: inputHtmlFileNameAndPath
	 * @modifier
	 */
	private static void GenerateDocxByHtml(String filePath, String fileName, String inputHtmlFileNameAndPath) throws IOException {
		//新建Document对象
		Document document = new Document();
		//添加section
		Section sec = document.addSection();

		String htmlText = readTextFromFile(inputHtmlFileNameAndPath);
		//添加段落并写入HTML文本
		sec.addParagraph().appendHTML(htmlText);

		//文档另存为PDF
		document.saveToFile(filePath + fileName, FileFormat.Docx);
	}


	public static String readTextFromFile(String fileName) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String content = null;
		while ((content = br.readLine()) != null) {
			sb.append(content);
		}
		return sb.toString();
	}
}
