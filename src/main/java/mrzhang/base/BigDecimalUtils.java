package mrzhang.base;

import java.math.BigDecimal;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/5
 */
public class BigDecimalUtils {


	public static void main(String[] args) {

		BigDecimal one = new BigDecimal("1");
		BigDecimal divide = one.divide(new BigDecimal("0.001"));

		int i = one.setScale(0, BigDecimal.ROUND_DOWN).intValue();
		System.out.println(divide.toString());
	}

}
