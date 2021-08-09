package mrzhang.niuke.od;

import java.util.*;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/5
 */
public class OD2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			Integer resGroupSize = Integer.valueOf(sc.nextLine());
			Integer inputGroupNum = Integer.valueOf(sc.nextLine());

			// 1. 全部入栈
			List<List<String>> list = new LinkedList<>();
			for (int i = 0; i < inputGroupNum; i++) {
				List<String> split = Arrays.asList(sc.nextLine().split(","));
				list.add(split);
			}

			// 2. 出栈

			// 当前的指针
			int[] p = new int[inputGroupNum];
			for (int i = 0; i < p.length; i++) {
				p[i] = -1;
			}

			// 记录结果
			List<String> resList = new ArrayList<>();
			while (true) {

				for (int i = 0; i < list.size(); i++) {
					List<String> each = list.get(i);
					int has = each.size() - p[i];
					if (has > 0) {
						int needDeal = resGroupSize;
						if (has > needDeal) {
							while (needDeal > 0) {
								p[i]++;
								resList.add(each.get(p[i]));
								needDeal--;
							}
						} else {
							// 不够，全部处理，p 移到最后
							while (p[i] < each.size() - 1) {
								p[i]++;
								resList.add(each.get(p[i]));
							}
						}
					}
				}

				// 判断是否完结
				int count = 0;
				for (int i = 0; i < list.size(); i++) {

					if (list.get(i).size() != 1 + p[i]) {
						count++;
					}
				}
				if (count == 0) {
					break;
				}
			}

			System.out.println(String.join(",", resList));
		}
	}

}
