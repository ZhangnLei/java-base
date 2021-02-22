package mrzhang.utils;

import com.sun.media.sound.SoftTuning;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangnianlei
 * @date 2020/3/31
 */
public class LegalEfficacyUtil {


	public static void main(String[] args) {
//		String idCard1 = "320721199502074612";System.out.println(idCard1+ ": "+isIDCard(idCard1));
//		String idCard2 = "32072119950207461X";System.out.println(idCard2+ ": "+isIDCard(idCard2));
//		String idCard3 = "3207211995020746112";System.out.println(idCard3+ ": "+isIDCard(idCard3));
//		String idCard4 = "32072119950207";System.out.println(idCard4+ ": "+isIDCard(idCard4));

		String phone0 = "10581528421";System.out.println(phone0+ ": "+isMobileNO(phone0));
		String phone8 = "11581528421";System.out.println(phone8+ ": "+isMobileNO(phone8));
		String phone9 = "12581528421";System.out.println(phone9+ ": "+isMobileNO(phone9));
		String phone1 = "13581528421";System.out.println(phone1+ ": "+isMobileNO(phone1));
		String phone2 = "14581528421";System.out.println(phone2+ ": "+isMobileNO(phone2));
		String phone3 = "15581528421";System.out.println(phone3+ ": "+isMobileNO(phone3));
		String phone4 = "16581528421";System.out.println(phone4+ ": "+isMobileNO(phone4));
		String phone5 = "17581528421";System.out.println(phone5+ ": "+isMobileNO(phone5));
		String phone6 = "18581528421";System.out.println(phone6+ ": "+isMobileNO(phone6));
		String phone7 = "19581528421";System.out.println(phone7+ ": "+isMobileNO(phone7));
		String phone71 = "139581528421";System.out.println(phone71+ ": "+isMobileNO(phone71));


		System.out.println();
		String email1 = "stepheAnr_ead@163.com";System.out.println(email1+ ": "+ isEmail(email1));
		String email2 = "stephenre-ad@163.com";System.out.println(email2+ ": "+ isEmail(email2));
		String email3 = "steph_enread@qq.com";System.out.println(email3+ ": "+ isEmail(email3));
		String email4 = "stephenread@163.com";System.out.println(email4+ ": "+ isEmail(email4));
		String email5 = "stephenread163.com";System.out.println(email5+ ": "+ isEmail(email5));
		String email6 = "LJ_88@1lin_in.C_OM";System.out.println(email6+ ": "+ isEmail(email6));
		String email7 = "STEPHENREAD_@163.COM";System.out.println(email7+ ": "+ isEmail(email7));
	}



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
//			String check = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$";
			String check = "^(((13[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[3-8]{1})|(18[0-9]{1})|(19[0-9]{1})|(14[0-9]{1}))+\\d{8})";
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
	 * @modifier zhangnianlei `2020/12/21`
	 */
	public static boolean isEmail(  String email){
		boolean flag = false;
		try{
			String check = "^([-_a-z0-9A-Z]+[-|\\.]?)+[-_a-z0-9A-Z]@([-_a-z0-9A-Z]+(-[-_a-z0-9A-Z]+)?\\.)+[-_a-z0-9A-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		}catch(Exception e){
			flag = false;
		}
		return flag;
	}


//
//	/**
//	 * @description 验证手机号码
//	 * @author zhangnianlei
//	 * @date 2020/3/31
//	 * @exception
//	 * @param: mobiles
//	 * @return: boolean
//	 * @modifier
//	 */
//	public static boolean isMobileNO(  String mobiles){
//		boolean flag = false;
//		try{
//			String check = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$";
//			Pattern regex = Pattern.compile(check);
//			Matcher m = regex .matcher(mobiles);
//			flag = m.matches();
//		}catch(Exception e){
//			flag = false;
//		}
//		return flag;
//	}


//	/**
//	 * @description 验证邮箱地址
//	 * @author zhangnianlei
//	 * @date 2020/3/31
//	 * @exception
//	 * @param: email
//	 * @return: boolean
//	 * @modifier
//	 */
//	public static boolean isEmail(  String email){
//		boolean flag = false;
//		try{
////			String check = "^[_a-z0-9-]+(\\.[-_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*$";
////			String check = "^[-_a-z0-9A-Z]+(\\.[-_a-z0-9A-Z]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*$";
//			String check = "^([-_a-z0-9A-Z]+[-|\\.]?)+[-_a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
//			Pattern regex = Pattern.compile(check);
//			Matcher matcher = regex.matcher(email);
//			flag = matcher.matches();
//		}catch(Exception e){
//			flag = false;
//		}
//		return flag;
//	}


//
//	/**
//	 * @description 验证邮箱地址
//	 * @author zhangnianlei
//	 * @date 2020/3/31
//	 * @exception
//	 * @param: email
//	 * @return: boolean
//	 * @modifier zhangnianlei `2020/12/21`
//	 */
//	public static boolean isEmail(  String email){
//		boolean flag = false;
//		try{
//			String check = "^([-_a-z0-9A-Z]+[-|\\.]?)+[-_a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
//			Pattern regex = Pattern.compile(check);
//			Matcher matcher = regex.matcher(email);
//			flag = matcher.matches();
//		}catch(Exception e){
//			flag = false;
//		}
//		return flag;
//	}



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
		String REGEX_ID_CARD = "((^\\d{17}(([0-9])|X)$)|(^\\d{14}(([0-9])|X)$))";
		return Pattern.matches(REGEX_ID_CARD, idCard);
	}


	/**
	 * @description
	 * 	//假设18位身份证号码:41000119910101123X  410001 19910101 123X
	 * 		//^开头
	 * 		//[1-9] 第一位1-9中的一个      4
	 * 		//\\d{5} 五位数字           10001（前六位省市县地区）
	 * 		//(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
	 * 		//\\d{2}                    91（年份）
	 * 		//((0[1-9])|(10|11|12))     01（月份）
	 * 		//(([0-2][1-9])|10|20|30|31)01（日期）
	 * 		//\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
	 * 		//[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
	 * 		//$结尾
	 *
	 * 		//假设15位身份证号码:410001910101123  410001 910101 123
	 * 		//^开头
	 * 		//[1-9] 第一位1-9中的一个      4
	 * 		//\\d{5} 五位数字           10001（前六位省市县地区）
	 * 		//\\d{2}                    91（年份）
	 * 		//((0[1-9])|(10|11|12))     01（月份）
	 * 		//(([0-2][1-9])|10|20|30|31)01（日期）
	 * 		//\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
	 * 		//$结尾
	 *
	 * @author zhangnianlei
	 * @date 2020/12/21
	 * @exception
	 * @param: IDNumber
	 * @return: boolean
	 * @modifier
	 */
	public static boolean isIDNumber(String IDNumber) {
		if (IDNumber == null || "".equals(IDNumber)) {
			return false;
		}
		// 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
		String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
				"(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

		boolean matches = IDNumber.matches(regularExpression);

		//判断第18位校验值
		if (matches) {

			if (IDNumber.length() == 18) {
				try {
					char[] charArray = IDNumber.toCharArray();
					//前十七位加权因子
					int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
					//这是除以11后，可能产生的11位余数对应的验证码
					String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
					int sum = 0;
					for (int i = 0; i < idCardWi.length; i++) {
						int current = Integer.parseInt(String.valueOf(charArray[i]));
						int count = current * idCardWi[i];
						sum += count;
					}
					char idCardLast = charArray[17];
					int idCardMod = sum % 11;
					if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
						return true;
					} else {
						return false;
					}

				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}

		}
		return matches;
	}


	/**
	 * @description 判断字符串是否为正确的时间格式
	 * @author zhangnianlei
	 * @date 2020/4/30
	 * @exception
	 * @param: date
	 * @return: boolean
	 * @modifier
	 */
	public static boolean checkDate(String date) {
		if (StringUtils.isBlank(date)) {
			return true;
		}
		boolean b = false;
		try {
			LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			b = true;
		} catch (Exception e) {
			b = false;
		}
		if (!b) {
			try {
				LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				b = true;
			} catch (Exception e) {
				b = false;
			}
		}
		return b;
	}
}
