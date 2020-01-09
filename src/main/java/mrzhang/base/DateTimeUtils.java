package mrzhang.base;

import java.sql.Date;

/**
 * @author zhangnianlei
 * @date 2020/1/9
 */
public class DateTimeUtils {
	public static void main(String[] args) {
		Object newSqlDate = new java.sql.Date(new java.util.Date().getTime());
		System.out.println("sqlDateToString***"+newSqlDate.toString());
	}
}
