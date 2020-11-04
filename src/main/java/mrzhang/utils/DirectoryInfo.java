package mrzhang.utils;

import joptsimple.internal.Strings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jsoup.nodes.Element;

import java.util.List;

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
	private Integer pid;
	private String name;
	private String position;
//	private Integer index;
//	private Integer siblingIndex;

	private String tagName;
	private Integer level;
	private Boolean isParent;
//	List<DirectoryInfo> child = null;

	public DirectoryInfo (Element element) {
		this.id = element.siblingIndex();
		this.position = "position" + element.siblingIndex();
		this.pid = 0;
		this.name = element.text();
		this.tagName = element.tagName();
	}
}
