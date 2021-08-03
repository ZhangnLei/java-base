package mrzhang.niuke.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class Hj68 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int size = Integer.parseInt(sc.nextLine());
			int orderFlag = Integer.parseInt(sc.nextLine());
			List<ScoreInfo> list = new ArrayList<>(size);
			for (int i = 0; i < size; i++) {
				String[] line = sc.nextLine().split(" ");
				list.add(new ScoreInfo(line[0], Integer.valueOf(line[1]), i));
			}


			if (1 == orderFlag) {
				list.stream()
						.sorted(Comparator.comparing((ScoreInfo s) -> s.score).thenComparing((ScoreInfo s) -> s.index))
						.forEach(each -> {
							System.out.println(each.toString());
						});
			} else {
				list.stream()
						.sorted(Comparator.comparing((ScoreInfo s) -> s.score).reversed().thenComparing((ScoreInfo s) -> s.index))
						.forEach(each -> {
							System.out.println(each.toString());
						});
			}


		}
	}

	public static class ScoreInfo {
		String name;
		int score;
		int index;


		public ScoreInfo(String name, int score, int index) {
			this.name = name;
			this.score = score;
			this.index = index;
		}


		@Override
		public String toString() {
			return name + " " + score;
		}

	}
}
