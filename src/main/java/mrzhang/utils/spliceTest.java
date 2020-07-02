package mrzhang.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangnianlei
 * @date 2020/5/14
 */
public class spliceTest {


	public static void main(String[] args) {
		Set<String> noSet = new TreeSet<>();
		add(noSet, ";BJSY-PMI0000922;BJSY-PMI0000923");
		add(noSet, ";BJSY-PMI0000922;BJSY-PMI0000913");
		add(noSet, "");
		add(noSet, null);
		noSet.remove("");

		System.out.println(JSON.toJSONString(noSet));
	}

	private static void add(Set<String> noSet, String pplanNos) {
		if (StringUtils.isNotBlank(pplanNos)) {
			String[] strings1 = pplanNos.split(";");
			System.out.println(JSON.toJSONString(strings1));
			noSet.addAll(Arrays.asList(strings1));
		}

	}
}
