package mrzhang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhangnianlei
 * @date 2019/12/4
 */
public class UseString {
	public static void main(String[] args) {

		String updateContent = "上级系统名称: 测试87613216465 <font color='red'><i>改为</i></font> ecif<br/>系统分级: 子系统 <font color='red'><i>改为</i></font> 主系统<br/>";
		String[] updateContentArray = updateContent.split("<br/>");
		for (String item : updateContentArray) {
			String updateType = item.substring(0, item.indexOf(":"));
			String[] updateContentSplit = item.substring(item.indexOf(":")+2).split("#改为#");
			JSONObject json = new JSONObject();
			json.put("updateItem", updateType);
			if (updateContentSplit.length > 1){
				json.put("updatePre",updateContentSplit[0]);
				json.put("updateAfter",updateContentSplit[1]);
				System.out.println("json:" + JSON.toJSONString(json));
			}
		}
	}
}
