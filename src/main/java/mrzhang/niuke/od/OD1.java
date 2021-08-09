package mrzhang.niuke.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/5
 */
public class OD1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] split = sc.nextLine().split("[(),]");

			List<String> numList = new ArrayList<>();
			for (int i = 0; i < split.length; i++) {
				if (isNum(split[i])) {
					numList.add(split[i]);
				}
			}

			List<Unit> units = new ArrayList<>();
			for (int i = 0; i < numList.size() - 1; i++) {
				String x = numList.get(i);
				String y = numList.get(i + 1);
				Integer distencce = getDistencce(x, y);
				if (distencce != null) {
					units.add(new Unit(Integer.valueOf(x), Integer.valueOf(y), distencce));
				}
			}
			if (units.size() == 0) {
				System.out.println("(0,0)");
			} else {

				List<Unit> collect = units.stream().sorted(Comparator.comparing(Unit::getDistence)).collect(Collectors.toList());
				Unit unit = collect.get(0);
				System.out.println("(" + unit.x + "," + unit.y + ")");
			}

		}

	}


	static boolean isNum(String str) {
		if (str == null) return false;
		if (str.length() == 0) return false;

		return str.matches("[0-9]+");
	}


	static boolean isTrueNum(String str) {
		if (str == null) return false;
		if (str.length() == 0) return false;
		Integer integer = Integer.valueOf(str);
		String string = String.valueOf(integer);
		return str.equals(string);
	}


	static class Unit {

		int x;

		int y;

		int distence;


		public int getDistence() {
			return distence;
		}


		public Unit(int x, int y, int distence) {
			this.x = x;
			this.y = y;
			this.distence = distence;
		}

	}


	static Integer getDistencce(String x, String y) {
		if (isTrueNum(x) && isTrueNum(y)) {
			Integer a = Integer.valueOf(x);
			Integer b = Integer.valueOf(y);
			return a * a + b * b;
		} else {
			return null;
		}

	}

}
