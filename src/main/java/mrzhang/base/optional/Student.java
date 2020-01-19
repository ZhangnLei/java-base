package mrzhang.base.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author zhangnianlei
 * @date 2020/1/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String name;
	private int age;
	private Integer score;

	/**
	 * @description 初始化数据
	 * @author zhangnianlei
	 * @date 2020/1/16
	 * @exception
	 * @return: java.util.List<mrzhang.base.optional.Student>
	 * @modifier
	 */
	public static List<Student> initData() {
		Student s1 = new Student("张三", 19, 80);
		Student s2 = new Student("李四", 19, 50);
		Student s3 = new Student("王五", 23, null);
		Student s4 = new Student("赵六", 16, 90);
		Student s5 = new Student("钱七", 18, 99);
		Student s6 = new Student("孙八", 20, 40);
		Student s7 = new Student("吴九", 21, 88);
		s7 = null;

		return Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
	}

	/**
	 * @description Java8之前的
	 * @author zhangnianlei
	 * @date 2020/1/16
	 * @exception
	 * @modifier
	 */
	public static void beforeJava8() {
		List<Student> studentList = initData();

		for (Student student : studentList) {
			if (student != null) {
				if (student.getAge() >= 18) {
					Integer score = student.getScore();
					if (score != null && score > 80) {
						System.out.println("入选：" + student.getName());
					}
				}
			}
		}
	}


	/**
	 * @description 使用Java8后的Optional类
	 * @author zhangnianlei
	 * @date 2020/1/16
	 * @exception
	 * @modifier
	 */
	public static void useJava8() {
		List<Student> studentList = initData();
		for (Student student : studentList) {
			Optional<Student> studentOptional = Optional.of(student);
			Integer score = studentOptional.filter(s -> s.getAge() >= 18).map(Student::getScore).orElse(0);

			if (score > 80) {
				System.out.println("入选：" + student.getName());
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("use before java8");
		beforeJava8();
		System.out.println("use java8");
		useJava8();
	}

}