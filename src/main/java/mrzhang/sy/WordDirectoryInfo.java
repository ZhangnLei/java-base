package mrzhang.sy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jsoup.nodes.Element;

/**
 * Word文档目录信息
 * @author zhangnianlei
 * @date 2020/11/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WordDirectoryInfo {


	/**
	 * 目录id
	 */
	private Integer id;

	/**
	 * 父级目录id
	 */
	private Integer pId;

	/**
	 * 标题名称前的数字
	 */
	private String titleNum;

	/**
	 * 父级标题名称前的数字
	 */
	private String pTitleNum;

	/**
	 * 标题的原始中文
	 */
	private String text;

	/**
	 * 标题名称 = titleNum + text
	 */
	private String name;

	/**
	 * 位置
	 */
	private String position;

	/**
	 * HTML的标签名
	 */
	private String tagName;

	/**
	 * 层级
	 */
	private Integer level;

	/**
	 * 标题所在当前层级的索引 (from 1)
	 */
	private Integer index;

	/**
	 * 是否是父级（有子集时便是父级）
	 */
	private Boolean isParent;

	/**
	 * 标签
	 */
	private String label;

	/**
	 * 内容
	 */
	private String content;

	public WordDirectoryInfo(Element element) {
		this.id = element.siblingIndex();
		this.position = "position" + element.siblingIndex();
		this.pId = 0;
		this.text = element.text();
		this.tagName = element.tagName();
	}
}
