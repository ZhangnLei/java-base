package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * <p>
 * 详细描述：
 * <p>
 * 接口说明
 * <p>
 * 原型：
 * <p>
 * int GetResult(vector &list)
 * <p>
 * 输入参数：
 * <p>
 * 无
 * <p>
 * 输出参数（指针指向的内存区域保证有效）：
 * <p>
 * list  鸡翁、鸡母、鸡雏组合的列表
 * <p>
 * 返回值：
 * <p>
 * -1 失败
 * <p>
 * 0 成功
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述：
 * 输入任何一个整数，即可运行程序。
 * <p>
 * 输出描述：
 * <p>
 * <p>
 * 示例1
 * 输入：
 * 1
 * 复制
 * 输出：
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 * 复制
 * @date 2021/8/5
 */
public class HJ72 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int x = 0; x < 21; x++) {
			for (int y = 0; y < 34; y++) {
				int z = 100 - x - y;
				if (z % 3 == 0 && 5 * x + 3 * y + z / 3 == 100) {
					System.out.println(x + " " + y + " " + z);
				}
			}
		}

	}

}
