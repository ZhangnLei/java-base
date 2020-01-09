package mrzhang.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnianlei
 * @date 2020/1/9
 */
public class GenerateTree {

	public static void main(String[] args) {
		List<App> applist = new ArrayList<>(14);

		applist.add(new App("004", "002", "a4"));
		applist.add(new App("005", "002", "a5"));
		applist.add(new App("006", "004", "a6"));
		applist.add(new App("007", "004", "a7"));

		applist.add(new App("b004", "b002", "ba4"));
		applist.add(new App("b005", "b002", "ba5"));
		applist.add(new App("b006", "b004", "ba6"));
		applist.add(new App("b007", "b004", "ba7"));

		getTree(applist);
	}

	private static void getTree(List<App> sonapplist) {
		List<App> applist = new ArrayList<>(14);
		applist.add(new App("001", "001", "a1"));
		applist.add(new App("002", "001", "a2"));
		applist.add(new App("003", "001", "a3"));
		applist.add(new App("b001", "b001", "ba1"));
		applist.add(new App("b002", "b001", "ba2"));
		applist.add(new App("b003", "b001", "ba3"));

		sonapplist.forEach(item -> {

		});

	}

}
