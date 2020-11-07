package mrzhang.utils;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * 将Word文档解析为Html
 * @author zhangnianlei
 * @date 2020/11/2
 */
public class ConvertWordToHtmlUtils {

	public static void main(String[] args) {
		String filePath="/Users/zhangdabao/Downloads/document.docx";
		getHtmlStringByDocx(filePath);
	}

	/**
	 * @description 将Word文档解析为Html
	 * @author zhangnianlei
	 * @date 2020/11/4
	 * @exception
	 * @param: filePath 文件路径
	 * @return: java.util.Map<java.lang.String, java.lang.Object>
	 * @modifier
	 */
	public static Map<String, Object> getHtmlStringByDocx(String filePath) {
		// log.info("getHtmlStringByDocx-param-filePath: {}", filePath);
		DocumentConverter converter = new DocumentConverter()
//				.disableEmbeddedStyleMap()
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
		// log.info("warning: {}", result.getWarnings().toString());
		Document doc = null;
		try {
			doc = Jsoup.parseBodyFragment(html);
		} catch (Exception e) {
			// log.error("将Word文档解析为Html出错: {}", e.getMessage());
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<>();

		if (null == doc || null == doc.body()) {
			// log.info("解析后获得的doc为空");
			map.put("htmlBody", null);
			map.put("directories", Collections.emptyList());
			return map;
		}

		List<WordDirectoryInfo> directories = null;
		String htmlBody = null;

		directories = getDirectoriesByDoc(doc);
		htmlBody = doc.body().html();

//		String htmlstr = doc.html();
		saveFile(htmlBody);
		System.out.println(htmlBody);
		map.put("htmlBody", htmlBody);
		map.put("directories", directories);
		return map;
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
	private static List<WordDirectoryInfo> getDirectoriesByDoc(Document doc) {
		if (null == doc) {
			return Collections.emptyList();
		}
		Elements allElements = doc.getAllElements();
		Map<String, Integer> titelMap = getTitelMap();
		List<WordDirectoryInfo> wordDirectoryInfos = new ArrayList<>();
		for (Element item : allElements) {
			if (titelMap.containsKey(item.tagName())) {
				WordDirectoryInfo dir = new WordDirectoryInfo(item);
				item.attr("id", dir.getPosition());
				dir.setLevel(titelMap.get(item.tagName()));
				wordDirectoryInfos.add(dir);
			}
			if (StringUtils.isNotBlank(item.text()) && item.text().indexOf(" ") > -1) {
				System.out.println(item.text());
				String replace = item.text().replace(" ", "&nbsp;");
				System.out.println(replace);
				item.text(replace);
			}
		}

		Map<Integer, Integer> parentMap = new HashMap<>(10);
		// 记录所有是父节点的id
		Set<Integer> pidSet = new HashSet<>(wordDirectoryInfos.size());
		// key: level； value: id。
		for (WordDirectoryInfo item : wordDirectoryInfos) {
			parentMap.put(item.getLevel(), item.getId());
			if (parentMap.containsKey(item.getLevel() - 1)) {
				item.setPId(parentMap.get(item.getLevel() - 1));
				pidSet.add(parentMap.get(item.getLevel() - 1));
			}
		}
		for (WordDirectoryInfo item : wordDirectoryInfos) {
			item.setIsParent(pidSet.contains(item.getId()));
		}
		return wordDirectoryInfos;
	}


	/**
	 * @description 默认识别九级标题
	 * @author zhangnianlei
	 * @date 2020/11/4
	 * @exception
	 * @return: java.util.Map<java.lang.String, java.lang.Integer>
	 * @modifier
	 */
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

}
