package mrzhang.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * ModelMapper使用示例
 * @author zhangnianlei
 * @date 2020/1/15
 */
public class ModelMapperUse {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public static class Apple {
		private String id ;
		private String name ;
		private String createAge ;
		private List<A1> codelist;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public static class AppleVo {
		private String name ;
		private String id ;
		private List<A2> codelist;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public static class AppleDTO {
		private String name ;
		private String create_age ;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public static class A1 {
		private String name ;
		private String create_age ;
	}


	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public static class A2 {
		private String name ;
	}

	public static void main(String[] args) {
		List<A1> codeList = new ArrayList<>(5);
		codeList.add(new A1("java", "12"));
		codeList.add(new A1("c++", "12"));
		codeList.add(new A1("php", "12"));
		Apple apple = new Apple("1", "zhang", "19", codeList);
		System.out.println(apple.toString());
		AppleVo appleVo = new ModelMapper().map(apple, AppleVo.class);
		System.out.println(appleVo.toString());

		/**
		 * 运行代码后输出：
		 * ModelMapperUse.Apple(id=1, name=zhang, createAge=19, codelist=[java, c++])
		 * ModelMapperUse.AppleVo(name=zhang, id=1, codelist=[java, c++])
		 * ModelMapperUse.AppleDTO(name=zhang, create_age=null)
		 */
	}
}
