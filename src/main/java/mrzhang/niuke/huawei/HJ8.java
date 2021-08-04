package mrzhang.niuke.huawei;

import javax.swing.*;
import java.util.*;

/**
 * @author zhangnianlei
 * @description
 * 描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述：
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入：
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 复制
 * 输出：
 * 0 3
 * 1 2
 * 3 4
 *
 * @date 2021/8/4
 */
public class HJ8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int size = Integer.parseInt(sc.nextLine());
			Map<Integer, Integer> map = new TreeMap<>();
			for (int i = 0; i < size; i++) {
				String[] line = sc.nextLine().split(" ");
				int key = Integer.parseInt(line[0]);
				int value = Integer.parseInt(line[1]);
				Integer getValue = map.get(key);
				if (null == getValue) {
					map.put(key, value);
				} else {
					map.put(key, value + getValue);
				}
			}
			map.entrySet().forEach(each -> {
				System.out.println(each.getKey() + " " + each.getValue());
			});
		}
	}

}
