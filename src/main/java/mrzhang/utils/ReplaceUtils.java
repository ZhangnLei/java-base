package mrzhang.utils;

import mrzhang.sy.AppSysUnitVo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author zhangnianlei
 * @date 2021/2/25
 */
public class ReplaceUtils {


	public static void main(String[] args) {
//		String fileName = "1报表.xlsx";
//		fileName = fileName.replace(".docx", "");
//		fileName = fileName.replace(".doc", "");
//		fileName = fileName.replace(".xlsx", "");
//		fileName = fileName.replace(".xls", "");
//
//
//		System.out.println(fileName);
//

//		String path = System.getProperty("user.dir") + "/excel";
//		String filePath = path + "/contractExamine.xls";
//		System.out.println(filePath);


		Optional<AppSysUnitVo> first = null;
//		person.setAge(2);
//		Optional.ofNullable(first).get();

//		if (Optional.ofNullable(first).isPresent()) {
//			first.get();
//		} else {
//			throw new RuntimeException("nono ");
//		}


//		AppSysUnitVo appSysUnitVo = Optional.ofNullable(first).isPresent() ? first.get() : null;


		List<String> strs = Arrays.asList("d", "b", "a", "c", "a");
//		Optional<String> min = strs.stream().min(Comparator.comparing(Function.identity()));
//		Optional<String> max = strs.stream().max((o1, o2) -> o1.compareTo(o2));
//		System.out.println(String.format("min:%s; max:%s", min.get(), max.get()));// min:a; max:d

//		Optional<String> aa = strs.stream().filter(str -> !str.equals("a")).findFirst();
//		Optional<String> bb = strs.stream().filter(str -> !str.equals("a")).findAny();

		Optional<String> aa1 = strs.parallelStream().filter(str -> str.equals("e")).findFirst();
//		Optional<String> bb1 = strs.parallelStream().filter(str -> !str.equals("a")).findAny();

//		System.out.println(aa.get() + "===" + bb.get());// d===d
		System.out.println(aa1.isPresent() ? aa1.get() : "null");


	}
}
