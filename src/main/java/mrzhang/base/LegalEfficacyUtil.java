package mrzhang.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangnianlei
 * @date 2020/3/31
 */
public class LegalEfficacyUtil {

	/**
	 * @description 验证手机号码
	 * @author zhangnianlei
	 * @date 2020/3/31
	 * @exception
	 * @param: mobiles
	 * @return: boolean
	 * @modifier
	 */
	public static boolean isMobileNO(  String mobiles){
		boolean flag = false;
		try{
			String check = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$";
			Pattern regex = Pattern.compile(check);
			Matcher m = regex .matcher(mobiles);
			flag = m.matches();
		}catch(Exception e){
			flag = false;
		}
		return flag;
	}


	/**
	 * @description 验证邮箱地址
	 * @author zhangnianlei
	 * @date 2020/3/31
	 * @exception
	 * @param: email
	 * @return: boolean
	 * @modifier
	 */
	public static boolean isEmail(  String email){
		boolean flag = false;
		try{
			String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		}catch(Exception e){
			flag = false;
		}
		return flag;
	}


	/**
	 * @description 校验身份证
	 * @author zhangnianlei
	 * @date 2020/3/31
	 * @exception
	 * @param: idCard
	 * @return: boolean
	 * @modifier
	 */
	public static boolean isIDCard(String idCard) {
		String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
		return Pattern.matches(REGEX_ID_CARD, idCard);
	}

	public static void main(String[] args) {
		System.out.println("mail");
		System.out.println(isEmail("zhang@mail.com1"));
		System.out.println(isEmail("zhang@mail1.com"));
		System.out.println(isEmail("zhan1g@mail.com"));
		System.out.println("id card");
		System.out.println(isIDCard("320721199502074612"));
		System.out.println(isIDCard("320721199502074611"));
		System.out.println(isIDCard("320721199502074613"));
		System.out.println(isIDCard("320721191502D74613"));
		System.out.println("mobile");
		System.out.println(isMobileNO("18581528421"));
		System.out.println(isMobileNO("15581528421"));
		System.out.println(isMobileNO("1g581528421"));
		System.out.println(isMobileNO("185834528421"));


	}

}
