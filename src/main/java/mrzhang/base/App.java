package mrzhang.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangnianlei
 * @date 2020/1/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class App {
	private String imternlNo;
	private String suprNo;
	private String name;
	private List<App> children;

	public App(String imternlNo, String suprNo, String name) {
		this.imternlNo = imternlNo;
		this.suprNo = suprNo;
		this.name = name;
	}
}
