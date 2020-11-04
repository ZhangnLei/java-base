package mrzhang.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;

import java.io.*;
import java.util.*;

/**
 * @author zhangnianlei
 * @date 2020/11/2
 */
public class ConvertToHtmlUtils {

	public static void main(String[] args) {
		String filePath="/Users/zhangdabao/Downloads/document.docx";
		getHtmlStringByDocx(filePath);
	}


	private static Map<String, Object> getHtmlStringByDocx(String filePath) {
		DocumentConverter converter = new DocumentConverter()
//				.disableEmbeddedStyleMap();
				.addStyleMap("b => em")
				.addStyleMap("i => strong")
				.addStyleMap("u => em")
				.addStyleMap("strike => del")
				.addStyleMap("comment-reference => sup")
				.addStyleMap("p[style-name='Section Title'] => h1:fresh")
				.addStyleMap("p[style-name='Subsection Title'] => h2:fresh")
				.addStyleMap("p[style-name='Code Block'] => pre:separator('\\n')");

		Result<String> result = null;
		Result<String> raw = null;
		try {
			result = converter.convertToHtml(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String html = result.getValue();
		// TODO: 2020/11/4 delete sout, change to logger
		System.out.println("warning: "+ result.getWarnings().toString());
		Document doc = null;
		try {
			doc = Jsoup.parseBodyFragment(html);
		} catch (Exception e) {
			e.printStackTrace();
		}


		List<DirectoryInfo> directories = getDirectoriesByDoc(doc);
		String htmlBody = doc.body().html();
		String htmlstr = doc.html();
//		设置样式
		htmlstr = htmlstr.replace("<head>", getFont());
		// TODO: 2020/11/4 delete
		saveFile(htmlstr);
		Map<String, Object> map = new HashMap<>();
		// TODO: 2020/11/4 put map
		map.put("htmlBody", htmlBody);
		map.put("directories", directories);
		return map;
	}


	/**
	 * @description 保存HTML文件到本地
	 * @author zhangnianlei
	 * @date 2020/11/4
	 * @exception
	 * @param: restring
	 * @modifier
	 */
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


	/**
	 * @description 根据doc对象获取目录
	 * @author zhangnianlei
	 * @date 2020/11/4
	 * @exception
	 * @param: doc
	 * @return: java.util.List<mrzhang.utils.DirectoryInfo>
	 * @modifier
	 */
	private static List<DirectoryInfo> getDirectoriesByDoc(Document doc) {
		if (null == doc) {
			return Collections.emptyList();
		}
		Elements allElements = doc.getAllElements();
		Map<String, Integer> titelMap = getTitelMap();


		List<DirectoryInfo> directoryInfos = new ArrayList<>();
		for (Element item : allElements) {
			if (titelMap.containsKey(item.tagName())) {
				DirectoryInfo dir = new DirectoryInfo(item);
				item.attr("id", dir.getPosition());
				dir.setLevel(titelMap.get(item.tagName()));
				directoryInfos.add(dir);
			}
		}

		Map<Integer, Integer> parentMap = new HashMap<>(10);
		// 记录所有是父节点的id
		Set<Integer> pidSet = new HashSet<>(directoryInfos.size());
		// key : level , value : id .
		for (DirectoryInfo item : directoryInfos) {
			parentMap.put(item.getLevel(), item.getId());
			if (parentMap.containsKey(item.getLevel() - 1)) {
				item.setPid(parentMap.get(item.getLevel() - 1));
				pidSet.add(parentMap.get(item.getLevel() - 1));
			}
		}

		for (DirectoryInfo item : directoryInfos) {
			item.setIsParent(pidSet.contains(item.getId()));
		}


		// TODO: 2020/11/4 delete
		System.out.println("directoryInfos : ");
		// TODO: 2020/11/4 delete
		for (DirectoryInfo info : directoryInfos) {
			System.out.println(info);
		}
		return directoryInfos;
	}

	private static String getFont() {
		String style = "<head> \n" +
				" \t<style type=\"text/css\">\n" +
				" \t\tbody\n" +
				"\t\t{\n" +
				"\t\t    background-color:#efefef;\n" +
				"\t\t}\n" +
				"\t\th1\n" +
				"\t\t{\n" +
				"\t\t\t\n" +
				"\t\t}\n" +
				"\t\th2\n" +
				"\t\t{\n" +
				"\t\t\tpadding-left: 10px;\n" +
				"\t\t}\n" +
				"\t\th3\n" +
				"\t\t{\n" +
				"\t\t\tpadding-left: 20px;\n" +
				"\t\t}\n" +
				"\t\th4\n" +
				"\t\t{\n" +
				"\t\t\tpadding-left: 30px;\n" +
				"\t\t}\n" +
				"\t\th5\n" +
				"\t\t{\n" +
				"\t\t\tpadding-left: 40px;\n" +
				"\t\t}\n" +
				"\t\th6, h7, h8, h9, h10\n" +
				"\t\t{\n" +
				"\t\t\tpadding-left: 50px;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\tp\n" +
				"\t\t{\n" +
				"\t\t\tpadding-left: 50px;\n" +
				"\t\t}\n" +
				"\t\ttable\n" +
				"\t\t{\n" +
				"\t\t\tfont-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
				"\t\t\tborder-collapse: inherit;\n" +
				"    \t\tpadding-left: 50px;\n" +
				"\t\t}\n" +
				"\t\ttd\n" +
				"\t\t{\n" +
				"\t\t\tborder:1px solid #98bf21;\n" +
				"\t\t\tpadding:3px 7px 2px 7px;\n" +
				"\t\t}\n" +
				"\t\tth \n" +
				"\t\t{\n" +
				"\t\t\tbackground-color:#A7C942;\n" +
				"\t\t\tcolor:#ffffff;\n" +
				"\t\t\tpadding:3px 7px 2px 7px;\n" +
				"\t\t}\n" +
				" \t</style>\n" +
				" ";
		return style;
	}


	private static Map<String, Integer> getTitelMap() {
		Map<String, Integer> map = new HashMap<>(10);
		map.put("h1", 1);
		map.put("h2", 2);
		map.put("h3", 3);
		map.put("h4", 4);
		map.put("h5", 5);
		map.put("h6", 6);
		map.put("h7", 7);
		map.put("h8", 8);
		map.put("h9", 9);
		return map;
	}

}
