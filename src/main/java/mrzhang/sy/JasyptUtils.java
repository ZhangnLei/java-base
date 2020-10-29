

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * @description Jasypt加密类
 * @author zhangnianlei
 * @date 2020/10/29
 * @exception
 * @modifier
 */
public class JasyptUtils {

	/**
	 * Jasypt生成加密结果
	 *
	 * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
	 * @param value    待加密值
	 * @return
	 */
	public static String encryptPwd(String password, String value) {
		PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
		encryptOr.setConfig(cryptOr(password));
		String result = encryptOr.encrypt(value);
		return result;
	}

	/**
	 * 解密
	 *
	 * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
	 * @param value    待解密密文
	 * @return
	 */
	public static String decyptPwd(String password, String value) {
		PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
		encryptOr.setConfig(cryptOr(password));
		String result = encryptOr.decrypt(value);
		return result;
	}

	public static SimpleStringPBEConfig cryptOr(String password) {
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(password);
		config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
//		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
//		config.setProviderName("ENC");
//		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		return config;
	}

	public static void main(String[] args) {
		// 加密,打印出来的就是密码
		System.out.println(encryptPwd("jetzhu", "123456"));
		System.out.println(encryptPwd("jetzhu", "123456"));
		System.out.println(encryptPwd("jetzhu", "123456"));
		// 解密
		System.out.println(decyptPwd("jetzhu", "EBcCI9dFaFULR/VCLIkkFg=="));
		System.out.println(decyptPwd("jetzhu", "w3QfbFXwQq6SCKMQWE00Aw=="));
		System.out.println(decyptPwd("jetzhu", "3f8CX62pDeOttWqV4laZPg=="));
	}

}
