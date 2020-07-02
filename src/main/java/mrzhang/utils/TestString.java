package mrzhang.utils;

import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author zhangnianlei
 * @date 2020/5/14
 */
public class TestString {

	public static void main(String[] args) {

		String desc = "";
		Map<String, Object> publicWindow = new HashMap<>();
//		publicWindow.put("relsWindowDesc", LocalDateTime.now());
//		String desc = publicWindow.get("relsWindowDesc").toString();
		if (null != publicWindow.get("relsWindowDesc")) {
			desc = publicWindow.get("relsWindowDesc").toString();
		}
		System.out.println(desc);
	}

}
