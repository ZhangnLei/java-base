package mrzhang.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangnianlei
 * @date 2021/2/21
 */
public class StatisticalCharactersUtils {
	public static void main(String[] args) {

		String errorCharacters = "e;:k,asei-aehi:ch?adi,aschnro!asrhl;:-pre;=yrre-:=ne,-lhngnd-e.ch.";
		String[] split = errorCharacters.split("");
		Map<String, Integer> map = new TreeMap();
		for (String s : split) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}

		List<StatisticalCharactersVO> voList = new ArrayList<>(map.size());
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			voList.add(new StatisticalCharactersVO(entry.getKey(), entry.getValue()));
		}

		List<StatisticalCharactersVO> sorted = voList.stream().sorted(Comparator.comparing(StatisticalCharactersVO::getTimes).reversed()).collect(Collectors.toList());
		sorted.forEach(item -> {
			System.out.println(item.getCharacter() + " -> " + item.getTimes());
		});
	}
}
