package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ17 {

	private final static String DIR_ABCD = "AWDS";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split(";");
			System.out.println(dealPosition(s));
		}
	}


	private static String dealPosition(String[] s) {

		int x = 0, y = 0;
		for (String each : s) {

			// 根据字符串（A10）构建一个指令对象，为空代表无效指令
			MoveOrder order = new MoveOrder().getMoveOrderByStr(each);
			if (null == order) continue;

			if ("A".equals(order.direction)) {
				x -= order.distance;
			} else if ("D".equals(order.direction)) {
				x += order.distance;
			} else if ("W".equals(order.direction)) {
				y += order.distance;
			} else {
				y -= order.distance;
			}
		}
		return x + "," + y;
	}


	/**
	 * @description 移动指令对象
	 * @author zhangnianlei
	 * @date 2021/8/2
	 * @throws
	 * @modifier
	 */
	public static class MoveOrder {

		/**
		 * 方位
		 */
		String direction;

		/**
		 * 距离
		 */
		Integer distance;


		public MoveOrder() {
		}


		public MoveOrder(String direction, Integer distance) {
			this.direction = direction;
			this.distance = distance;
		}

		/**
		 * @description 根据字符串（A10）构建一个指令对象，为空代表无效指令
		 * @author zhangnianlei
		 * @date 2021/8/2
		 * @throws
		 * @param: str
		 * @return: mrzhang.niuke.huawei.HJ17.MoveOrder
		 * @modifier
		 */
		public MoveOrder getMoveOrderByStr(String str) {
			if (null == str || str.length() == 0) return null;
			if (str.length() > 3) return null;
			String dir = String.valueOf(str.charAt(0));
			if (DIR_ABCD.indexOf(dir) <= -1) return null;

			for (int i = 1; i < str.length(); i++) {
				if (!Character.isDigit(str.charAt(i))) {
					return null;
				}
			}

			String num = str.substring(1, str.length());
			MoveOrder order = new MoveOrder(dir, Integer.valueOf(num));
			return order;
		}

	}

}
