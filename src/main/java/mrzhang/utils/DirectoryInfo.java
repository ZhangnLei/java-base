package mrzhang.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jsoup.nodes.Element;

/**
 * @author zhangnianlei
 * @date 2020/11/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DirectoryInfo {
	private Integer id;
	private Integer pId;
	private String name;
	private String position;
	private String tagName;
	private Integer level;
	private Boolean isParent;

	public DirectoryInfo (Element element) {
		this.id = element.siblingIndex();
		this.position = "position" + element.siblingIndex();
		this.pId = 0;
		this.name = element.text();
		this.tagName = element.tagName();
	}
}
