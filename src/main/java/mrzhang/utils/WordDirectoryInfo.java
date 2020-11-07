package mrzhang.utils;

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
	 * 目录名
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
	 * 是否是父级（有子集时便是父级）
	 */
	private Boolean isParent;

	/**
	 * 标签
	 */
	private String label;

	public WordDirectoryInfo(Element element) {
		this.id = element.siblingIndex();
		this.position = "position" + element.siblingIndex();
		this.pId = 0;
		this.name = element.text();
		this.tagName = element.tagName();
	}
}
