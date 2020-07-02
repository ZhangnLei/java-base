package mrzhang.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author zhangnianlei
 * @date 2020/5/14
 */
public class TreeSetTest {

	public static void main(String[] args) {
		List<PlanManageInfoEntity> list = new ArrayList<>();
		list.add(new PlanManageInfoEntity("1"));
		list.add(new PlanManageInfoEntity("1"));
		list.add(new PlanManageInfoEntity("2"));
		list.add(new PlanManageInfoEntity("3"));
		list.add(new PlanManageInfoEntity("4"));
		list.add(new PlanManageInfoEntity("5"));

		removeDuplicationByTreeSet(list);
		System.out.println(JSON.toJSONString(list));

	}

	public static void removeDuplicationByTreeSet(List<PlanManageInfoEntity> list) {
		TreeSet<PlanManageInfoEntity> set = new TreeSet(list);
		//把List集合所有元素清空
		list.clear();
		//把HashSet对象添加至List集合
		list.addAll(set);

	}

}
