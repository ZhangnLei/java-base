//package com.dcpms.service.demand.register.utils;
package mrzhang.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mrzhang.sy.WordDirectoryInfo;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;
import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 将Word文档解析为Html
 * @author zhangnianlei
 * @date 2020/11/2
 */
//@Slf4j
public class ConvertWordToHtmlUtils {

	private static final String DOT = ".";

	// todo delete. for test
	public static void main(String[] args) {
		parseFile();
	}



	/**
	 * @description 解析文件
	 * @author zhangnianlei
	 * @date 2020/12/9
	 * @exception
	 * @modifier
	 */
	// todo delete. for test
	private static void parseFile() {
		String tenantId = "XARY1001";
		String filePath = "group1/M00/00/01/rBKKR1-jc92Af_U2AAY7iaJZVLM35.docx";
		Map<String, Object> res = GetHtmlStringByDocx(tenantId, filePath);

		// save directoryInfo
		List<WordDirectoryInfo> directoryInfo = (List<WordDirectoryInfo>) res.get("directories");
		String directionJsonStr = JSON.toJSONString(directoryInfo);
		String jsonFilePath = "/Users/zhangdabao/Desktop/文档解析工具/json.json";
		saveFile(directionJsonStr, jsonFilePath);

		// save Html
		String htmlBody = (String) res.get("htmlBody");
		htmlBody = htmlBody.replace("<head>", getFont());
		String htmlFilePath = "/Users/zhangdabao/Desktop/文档解析工具/html.html";
		saveFile(htmlBody, htmlFilePath);
	}


	/**
	 * @description 保存HTML文件到本地
	 * @author zhangnianlei
	 * @date 2020/11/4
	 * @exception
	 * @param: restring
	 * @modifier
	 */
	// todo delete. for test
	private static void saveFile(String restring, String filePath) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			fos.write(restring.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static String getFont() {
		String style = "<head>" +
				"<style>\n" +
				"    code{white-space: pre-wrap;}\n" +
				"    span.smallcaps{font-variant: small-caps;}\n" +
				"    span.underline{text-decoration: underline;}\n" +
				"    div.column{display: inline-block; vertical-align: top; width: 50%;}\n" +
				"    div.hanging-indent{margin-left: 1.5em; text-indent: -1.5em;}\n" +
				"    ul.task-list{list-style: none;}\n" +
				"  </style>\n" +
				"  <style type=\"text/css\">\n" +
				"\n" +
				"\n" +
				"article,\n" +
				"aside,\n" +
				"details,\n" +
				"figcaption,\n" +
				"figure,\n" +
				"footer,\n" +
				"header,\n" +
				"hgroup,\n" +
				"main,\n" +
				"nav,\n" +
				"section,\n" +
				"summary {\n" +
				"display: block;\n" +
				"}\n" +
				"\n" +
				"audio,\n" +
				"canvas,\n" +
				"video {\n" +
				"display: inline-block;\n" +
				"}\n" +
				"\n" +
				"audio:not([controls]) {\n" +
				"display: none;\n" +
				"height: 0;\n" +
				"}\n" +
				"\n" +
				"[hidden],\n" +
				"template {\n" +
				"display: none;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"html {\n" +
				"font-family: sans-serif; \n" +
				"-ms-text-size-adjust: 100%; \n" +
				"-webkit-text-size-adjust: 100%; \n" +
				"}\n" +
				"\n" +
				"body {\n" +
				"margin: 0;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"a {\n" +
				"background: transparent;\n" +
				"}\n" +
				"\n" +
				"a:focus {\n" +
				"outline: thin dotted;\n" +
				"}\n" +
				"\n" +
				"a:active,\n" +
				"a:hover {\n" +
				"outline: 0;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"h1 {\n" +
				"font-size: 2em;\n" +
				"margin: 0.67em 0;\n" +
				"}\n" +
				"\n" +
				"abbr[title] {\n" +
				"border-bottom: 1px dotted;\n" +
				"}\n" +
				"\n" +
				"b,\n" +
				"strong {\n" +
				"font-weight: bold;\n" +
				"}\n" +
				"\n" +
				"dfn {\n" +
				"font-style: italic;\n" +
				"}\n" +
				"\n" +
				"hr {\n" +
				"-moz-box-sizing: content-box;\n" +
				"box-sizing: content-box;\n" +
				"height: 0;\n" +
				"}\n" +
				"\n" +
				"mark {\n" +
				"background: #ff0;\n" +
				"color: #000;\n" +
				"}\n" +
				"\n" +
				"code,\n" +
				"kbd,\n" +
				"pre,\n" +
				"samp {\n" +
				"font-family: monospace, serif;\n" +
				"font-size: 1em;\n" +
				"}\n" +
				"\n" +
				"pre {\n" +
				"white-space: pre-wrap;\n" +
				"}\n" +
				"\n" +
				"q {\n" +
				"quotes: \"\\201C\" \"\\201D\" \"\\2018\" \"\\2019\";\n" +
				"}\n" +
				"\n" +
				"small {\n" +
				"font-size: 80%;\n" +
				"}\n" +
				"\n" +
				"sub,\n" +
				"sup {\n" +
				"font-size: 75%;\n" +
				"line-height: 0;\n" +
				"position: relative;\n" +
				"vertical-align: baseline;\n" +
				"}\n" +
				"sup {\n" +
				"top: -0.5em;\n" +
				"}\n" +
				"sub {\n" +
				"bottom: -0.25em;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"img {\n" +
				"border: 0;\n" +
				"}\n" +
				"\n" +
				"svg:not(:root) {\n" +
				"overflow: hidden;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"figure {\n" +
				"margin: 0;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"fieldset {\n" +
				"border: 1px solid #c0c0c0;\n" +
				"margin: 0 2px;\n" +
				"padding: 0.35em 0.625em 0.75em;\n" +
				"}\n" +
				"\n" +
				"legend {\n" +
				"border: 0; \n" +
				"padding: 0; \n" +
				"}\n" +
				"\n" +
				"button,\n" +
				"input,\n" +
				"select,\n" +
				"textarea {\n" +
				"font-family: inherit; \n" +
				"font-size: 100%; \n" +
				"margin: 0; \n" +
				"}\n" +
				"\n" +
				"button,\n" +
				"input {\n" +
				"line-height: normal;\n" +
				"}\n" +
				"\n" +
				"button,\n" +
				"select {\n" +
				"text-transform: none;\n" +
				"}\n" +
				"\n" +
				"button,\n" +
				"html input[type=\"button\"], \n" +
				"input[type=\"reset\"],\n" +
				"input[type=\"submit\"] {\n" +
				"-webkit-appearance: button; \n" +
				"cursor: pointer; \n" +
				"}\n" +
				"\n" +
				"button[disabled],\n" +
				"html input[disabled] {\n" +
				"cursor: default;\n" +
				"}\n" +
				"\n" +
				"input[type=\"checkbox\"],\n" +
				"input[type=\"radio\"] {\n" +
				"box-sizing: border-box; \n" +
				"padding: 0; \n" +
				"}\n" +
				"\n" +
				"input[type=\"search\"] {\n" +
				"-webkit-appearance: textfield; \n" +
				"-moz-box-sizing: content-box;\n" +
				"-webkit-box-sizing: content-box; \n" +
				"box-sizing: content-box;\n" +
				"}\n" +
				"\n" +
				"input[type=\"search\"]::-webkit-search-cancel-button,\n" +
				"input[type=\"search\"]::-webkit-search-decoration {\n" +
				"-webkit-appearance: none;\n" +
				"}\n" +
				"\n" +
				"button::-moz-focus-inner,\n" +
				"input::-moz-focus-inner {\n" +
				"border: 0;\n" +
				"padding: 0;\n" +
				"}\n" +
				"\n" +
				"textarea {\n" +
				"overflow: auto; \n" +
				"vertical-align: top; \n" +
				"}\n" +
				"\n" +
				"\n" +
				"table {\n" +
				"border-collapse: collapse;\n" +
				"border-spacing: 0;\n" +
				"}\n" +
				".go-top {\n" +
				"position: fixed;\n" +
				"bottom: 2em;\n" +
				"right: 2em;\n" +
				"text-decoration: none;\n" +
				"background-color: #E0E0E0;\n" +
				"font-size: 12px;\n" +
				"padding: 1em;\n" +
				"display: inline;\n" +
				"}\n" +
				"\n" +
				"html,body{ margin: auto;\n" +
				"padding-right: 1em;\n" +
				"padding-left: 1em;\n" +
				"max-width: 44em; color:black;}*:not('#mkdbuttons'){margin:0;padding:0}body{font:13.34px helvetica,arial,freesans,clean,sans-serif;-webkit-font-smoothing:subpixel-antialiased;line-height:1.4;padding:3px;background:#fff;border-radius:3px;-moz-border-radius:3px;-webkit-border-radius:3px}p{margin:1em 0}a{color:#4183c4;text-decoration:none}body{background-color:#fff;padding:30px;margin:15px;font-size:14px;line-height:1.6}body>*:first-child{margin-top:0!important}body>*:last-child{margin-bottom:0!important}@media screen{body{box-shadow:0 0 0 1px #cacaca,0 0 0 4px #eee}}h1,h2,h3,h4,h5,h6{margin:20px 0 10px;padding:0;font-weight:bold;-webkit-font-smoothing:subpixel-antialiased;cursor:text}h1{font-size:28px;color:#000}h2{font-size:24px;border-bottom:1px solid #ccc;color:#000}h3{font-size:18px;color:#333}h4{font-size:16px;color:#333}h5{font-size:14px;color:#333}h6{color:#777;font-size:14px}p,blockquote,table,pre{margin:15px 0}ul{padding-left:30px}ol{padding-left:30px}ol li ul:first-of-type{margin-top:0}hr{background:transparent url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAYAAAAECAYAAACtBE5DAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBNYWNpbnRvc2giIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6OENDRjNBN0E2NTZBMTFFMEI3QjRBODM4NzJDMjlGNDgiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6OENDRjNBN0I2NTZBMTFFMEI3QjRBODM4NzJDMjlGNDgiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo4Q0NGM0E3ODY1NkExMUUwQjdCNEE4Mzg3MkMyOUY0OCIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo4Q0NGM0E3OTY1NkExMUUwQjdCNEE4Mzg3MkMyOUY0OCIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PqqezsUAAAAfSURBVHjaYmRABcYwBiM2QSA4y4hNEKYDQxAEAAIMAHNGAzhkPOlYAAAAAElFTkSuQmCC) repeat-x 0 0;border:0 none;color:#ccc;height:4px;padding:0}body>h2:first-child{margin-top:0;padding-top:0}body>h1:first-child{margin-top:0;padding-top:0}body>h1:first-child+h2{margin-top:0;padding-top:0}body>h3:first-child,body>h4:first-child,body>h5:first-child,body>h6:first-child{margin-top:0;padding-top:0}a:first-child h1,a:first-child h2,a:first-child h3,a:first-child h4,a:first-child h5,a:first-child h6{margin-top:0;padding-top:0}h1+p,h2+p,h3+p,h4+p,h5+p,h6+p,ul li>:first-child,ol li>:first-child{margin-top:0}dl{padding:0}dl dt{font-size:14px;font-weight:bold;font-style:italic;padding:0;margin:15px 0 5px}dl dt:first-child{padding:0}dl dt>:first-child{margin-top:0}dl dt>:last-child{margin-bottom:0}dl dd{margin:0 0 15px;padding:0 15px}dl dd>:first-child{margin-top:0}dl dd>:last-child{margin-bottom:0}blockquote{border-left:4px solid #DDD;padding:0 15px;color:#777}blockquote>:first-child{margin-top:0}blockquote>:last-child{margin-bottom:0}table{border-collapse:collapse;border-spacing:0;font-size:100%;font:inherit}table th{font-weight:bold;border:1px solid #ccc;padding:6px 13px}table td{border:1px solid #ccc;padding:6px 13px}table tr{border-top:1px solid #ccc;background-color:#fff}table tr:nth-child(2n){background-color:#f8f8f8}img{max-width:100%}code,tt{margin:0 2px;padding:0 5px;white-space:nowrap;border:1px solid #eaeaea;background-color:#f8f8f8;border-radius:3px;font-family:Consolas,'Liberation Mono',Courier,monospace;font-size:12px;color:#333}pre>code{margin:0;padding:0;white-space:pre;border:0;background:transparent}.highlight pre{background-color:#f8f8f8;border:1px solid #ccc;font-size:13px;line-height:19px;overflow:auto;padding:6px 10px;border-radius:3px}pre{background-color:#f8f8f8;border:1px solid #ccc;font-size:13px;line-height:19px;overflow:auto;padding:6px 10px;border-radius:3px}pre code,pre tt{background-color:transparent;border:0}.poetry pre{font-family:Georgia,Garamond,serif!important;font-style:italic;font-size:110%!important;line-height:1.6em;display:block;margin-left:1em}.poetry pre code{font-family:Georgia,Garamond,serif!important;word-break:break-all;word-break:break-word;-webkit-hyphens:auto;-moz-hyphens:auto;hyphens:auto;white-space:pre-wrap}sup,sub,a.footnote{font-size:1.4ex;height:0;line-height:1;vertical-align:super;position:relative}sub{vertical-align:sub;top:-1px}@media print{body{background:#fff}img,pre,blockquote,table,figure{page-break-inside:avoid}body{background:#fff;border:0}code{background-color:#fff;color:#333!important;padding:0 .2em;border:1px solid #dedede}pre{background:#fff}pre code{background-color:white!important;overflow:visible}}@media screen{body.inverted{color:#eee!important;border-color:#555;box-shadow:none}.inverted body,.inverted hr .inverted p,.inverted td,.inverted li,.inverted h1,.inverted h2,.inverted h3,.inverted h4,.inverted h5,.inverted h6,.inverted th,.inverted .math,.inverted caption,.inverted dd,.inverted dt,.inverted blockquote{color:#eee!important;border-color:#555;box-shadow:none}.inverted td,.inverted th{background:#333}.inverted h2{border-color:#555}.inverted hr{border-color:#777;border-width:1px!important}::selection{background:rgba(157,193,200,0.5)}h1::selection{background-color:rgba(45,156,208,0.3)}h2::selection{background-color:rgba(90,182,224,0.3)}h3::selection,h4::selection,h5::selection,h6::selection,li::selection,ol::selection{background-color:rgba(133,201,232,0.3)}code::selection{background-color:rgba(0,0,0,0.7);color:#eee}code span::selection{background-color:rgba(0,0,0,0.7)!important;color:#eee!important}a::selection{background-color:rgba(255,230,102,0.2)}.inverted a::selection{background-color:rgba(255,230,102,0.6)}td::selection,th::selection,caption::selection{background-color:rgba(180,237,95,0.5)}.inverted{background:#0b2531;background:#252a2a}.inverted body{background:#252a2a}.inverted a{color:#acd1d5}}.highlight .c{color:#998;font-style:italic}.highlight .err{color:#a61717;background-color:#e3d2d2}.highlight .k,.highlight .o{font-weight:bold}.highlight .cm{color:#998;font-style:italic}.highlight .cp{color:#999;font-weight:bold}.highlight .c1{color:#998;font-style:italic}.highlight .cs{color:#999;font-weight:bold;font-style:italic}.highlight .gd{color:#000;background-color:#fdd}.highlight .gd .x{color:#000;background-color:#faa}.highlight .ge{font-style:italic}.highlight .gr{color:#a00}.highlight .gh{color:#999}.highlight .gi{color:#000;background-color:#dfd}.highlight .gi .x{color:#000;background-color:#afa}.highlight .go{color:#888}.highlight .gp{color:#555}.highlight .gs{font-weight:bold}.highlight .gu{color:#800080;font-weight:bold}.highlight .gt{color:#a00}.highlight .kc,.highlight .kd,.highlight .kn,.highlight .kp,.highlight .kr{font-weight:bold}.highlight .kt{color:#458;font-weight:bold}.highlight .m{color:#099}.highlight .s{color:#d14}.highlight .na{color:#008080}.highlight .nb{color:#0086b3}.highlight .nc{color:#458;font-weight:bold}.highlight .no{color:#008080}.highlight .ni{color:#800080}.highlight .ne,.highlight .nf{color:#900;font-weight:bold}.highlight .nn{color:#555}.highlight .nt{color:#000080}.highlight .nv{color:#008080}.highlight .ow{font-weight:bold}.highlight .w{color:#bbb}.highlight .mf,.highlight .mh,.highlight .mi,.highlight .mo{color:#099}.highlight .sb,.highlight .sc,.highlight .sd,.highlight .s2,.highlight .se,.highlight .sh,.highlight .si,.highlight .sx{color:#d14}.highlight .sr{color:#009926}.highlight .s1{color:#d14}.highlight .ss{color:#990073}.highlight .bp{color:#999}.highlight .vc,.highlight .vg,.highlight .vi{color:#008080}.highlight .il{color:#099}.highlight .gc{color:#999;background-color:#eaf2f5}.type-csharp .highlight .k,.type-csharp .highlight .kt{color:#00F}.type-csharp .highlight .nf{color:#000;font-weight:normal}.type-csharp .highlight .nc{color:#2b91af}.type-csharp .highlight .nn{color:#000}.type-csharp .highlight .s,.type-csharp .highlight .sc{color:#a31515}\n" +
				"</style>" +
				" ";
		return style;
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
	public static Map<String, Object> GetHtmlStringByDocx(String tenantId, String filePath) {
		// log.info("getHtmlStringByDocx-param-filePath: {}", filePath);
		Map<String, Object> map = new HashMap<>();
		map.put("htmlBody", null);
		map.put("directories", Collections.emptyList());
		DocumentConverter converter = new DocumentConverter()
//				.disableEmbeddedStyleMap()
				.addStyleMap("b => em")
				.addStyleMap("i => strong")
				.addStyleMap("u => em")
				.addStyleMap("p[style-name='Code Block'] => pre")
				.addStyleMap("strike => del")
				.addStyleMap("comment-reference => sup")
				.addStyleMap("p[style-name='Section Title'] => h1:fresh")
				.addStyleMap("p[style-name='Subsection Title'] => h2:fresh")
				.addStyleMap("p[style-name='Code Block'] => pre:fresh");
		Result<String> result = null;
		Result<String> raw = null;
		// TODO: 2020/11/5 open
//		InputStream fileStream = DownFIleUtils.GetInputStreamByFilePath(tenantId, filePath);
//		if (null == fileStream) {
//			// log.error(">>>getHtmlStringByDocx-文件下载失败，请检查文件是否存在");
//			map.put("errorMsg", "文件解析失败，请检查文件是否存在");
//			return map;
//		}
//		try {
//			result = converter.convertToHtml(fileStream);
		// TODO: 2020/11/5 delete 2 line
		try {
//			result = converter.convertToHtml(new File("/Users/zhangdabao/Desktop/文档解析工具/document.docx"));
			result = converter.convertToHtml(new File("/Users/zhangdabao/Desktop/文档解析工具/盛京银行应用开发类和数据类需求（模板）-V0.2.docx"));
		} catch (IOException e) {
			// log.error(">>>getHtmlStringByDocx-文件解析失败，请检查上传的文件", e);
			map.put("errorMsg", "文件解析失败，请检查上传的文件");
			return map;
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

		if (null == doc || null == doc.body()) {
			// log.info("解析后获得的doc为空");
			map.put("errorMsg", "文件解析失败，解析后获得的doc为空");
			return map;
		}

		List<WordDirectoryInfo> directories = null;
		String htmlBody = null;
		try {
			directories = GetDirectoriesByDoc(doc);
			// TODO: 2020/11/5 change
//			htmlBody = doc.body().html();
			htmlBody = doc.html();
		} catch (Exception e) {
			// log.error("获取文件目录失败：{}", e.getMessage());
			map.put("errorMsg", "获取文件目录失败");
			return map;
		}
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
	private static List<WordDirectoryInfo> GetDirectoriesByDoc(Document doc) {
		if (null == doc) {
			return Collections.emptyList();
		}
		Elements allElements = doc.getAllElements();
		Map<String, Integer> titelMap = getTitelMap();
		// 存放目录列表
		List<WordDirectoryInfo> wordDirectoryInfos = new ArrayList<>();
		// key: level； value: id。
		Map<Integer, Integer> parentMap = new HashMap<>(10);
		// 记录所有是父节点的id
		Set<Integer> pidSet = new HashSet<>(wordDirectoryInfos.size());
		// 记录上一个目录
		WordDirectoryInfo lastItem = null;
		// 记录上一个兄弟目录
		WordDirectoryInfo lastBro = null;
		for (Element element : allElements) {
			// 元素为目录时，将元素添加到目录列表
//			element.attr("data-id", String.valueOf(element.siblingIndex()));
			if (titelMap.containsKey(element.tagName())) {
				// 构建目录元素
				WordDirectoryInfo item = new WordDirectoryInfo(element);
				element.attr("id", item.getPosition());
				item.setLevel(titelMap.get(element.tagName()));
				wordDirectoryInfos.add(item);

				// 记录pid与level
				parentMap.put(item.getLevel(), item.getId());
				if (parentMap.containsKey(item.getLevel() - 1)) {
					// 设置pId
					item.setPId(parentMap.get(item.getLevel() - 1));
					pidSet.add(parentMap.get(item.getLevel() - 1));
				}

				// 2020/11/5 添加标题前的数字
				if (null == lastItem) {
					item.setIndex(1);
					item.setTitleNum("1");
				} else if (item.getPId().equals(lastItem.getPId())) {
					item.setIndex(lastItem.getIndex() + 1);
					item.setPTitleNum(lastItem.getPTitleNum());
				} else if (item.getPId().equals(lastItem.getId())) {
					item.setIndex(1);
					item.setPTitleNum(lastItem.getTitleNum());
				} else if (item.getLevel() < lastItem.getLevel()) {
					lastBro = getLastBrotherNode(wordDirectoryInfos, item);
					if (null == lastBro) {
						item.setIndex(1);
						item.setTitleNum("1");
					} else {
						item.setIndex(lastBro.getIndex() + 1);
						item.setPTitleNum(lastBro.getPTitleNum());
					}
				}

				String titleNum = StringUtils.isNotBlank(item.getPTitleNum()) ? item.getPTitleNum() + DOT + item.getIndex() : String.valueOf(item.getIndex());
				item.setTitleNum(titleNum);
				item.setName(item.getTitleNum() + " " + item.getText());
				element.text(item.getName());
				lastItem = item;
			}
		}

		for (WordDirectoryInfo item : wordDirectoryInfos) {
			item.setIsParent(pidSet.contains(item.getId()));
		}

		int lastElementId = allElements.get(allElements.size() - 1).siblingIndex();
		// 添加content
		for (int i = 0; i < wordDirectoryInfos.size(); i++) {
			WordDirectoryInfo item = wordDirectoryInfos.get(i);
			if (!item.getIsParent()) {
				Integer currentId = item.getId() + 1;
				Integer nextId = i + 1 >= wordDirectoryInfos.size() ? lastElementId : wordDirectoryInfos.get(i + 1).getId() - 1;
				item.setContent(getContentByIndex(allElements, currentId, nextId));
			}
		}
		return wordDirectoryInfos;
	}


	private static String getContentByIndex(Elements allElements, Integer start, Integer end) {
		StringBuilder content = new StringBuilder();
		allElements.forEach(item -> {
			if (item.siblingIndex() >= start && item.siblingIndex() <= end ) {
				content.append(item.outerHtml());
			}
		});
		return content.toString();
	}


	/**
	 * @description 寻找上一个兄弟目录
	 * @author zhangnianlei
	 * @date 2020/11/6
	 * @exception
	 * @param: wordDirectoryInfos
	 * @param: item
	 * @return: com.xray.service.biz.apparch.demand.vo.WordDirectoryInfo
	 * @modifier
	 */
	private static WordDirectoryInfo getLastBrotherNode(List<WordDirectoryInfo> list, WordDirectoryInfo dir) {

		List<WordDirectoryInfo> collect = list.stream().filter(item -> item.getPId() == dir.getPId() && item.getId() != dir.getId()).sorted((a1, a2) -> a2.getId() - a1.getId()).limit(1).collect(Collectors.toList());
		if (CollectionUtils.isEmpty(collect)) {
			return null;
		}
		return collect.get(0);
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


}
