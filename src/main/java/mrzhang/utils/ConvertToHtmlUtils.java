package mrzhang.utils;

import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;

import java.io.*;
import java.util.Set;

/**
 * @author zhangnianlei
 * @date 2020/11/2
 */
public class ConvertToHtmlUtils {

	public static void main(String[] args) {
		DocumentConverter converter = new DocumentConverter()
//				.disableDefaultStyleMap();
				.addStyleMap("b => em")
				.addStyleMap("i => strong")
//				.addStyleMap("u => em")
				.addStyleMap("strike => del")
				.addStyleMap("comment-reference => sup")
				.addStyleMap("p[style-name='Section Title'] => h1:fresh")
				.addStyleMap("p[style-name='Subsection Title'] => h2:fresh")
				.addStyleMap("p[style-name='Code Block'] => pre:separator('\\n')");

		Result<String> result = null;
		Result<String> raw = null;
		String filePath="/Users/zhangdabao/Downloads/document.docx";
		try {
			result = converter.convertToHtml(new File(filePath));
			raw = converter.extractRawText(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String html = result.getValue();
		Set<String> warnings = result.getWarnings();

		System.out.println(warnings);
//		System.out.println(raw.getValue());
//		System.out.println(html);

		html = html.replace("<p>", "<p>&nbsp;&nbsp;&nbsp;&nbsp;");
//		html = html.replace(" ", "&nbsp;&nbsp;");
//		System.out.println(html);
		System.out.println(html.length());

		saveFile(html);
	}

	private static void saveFile(String restring) {
		String filePath="/Users/zhangdabao/Downloads/html.html";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			fos.write(restring.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
