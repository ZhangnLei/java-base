package mrzhang.sy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description 实体
 * @author zhangnianlei
 * @date 2020/7/16
 * @exception
 * @modifier
 */
@Data
@NoArgsConstructor
public class AppSysUnitVo extends CommonField {

	private static final long serialVersionUID = 1L;

	private List<AppSysUnitVo> children = null;

	/**
	 * 租户编号
	 */
	public String tenantsNo;

	/**
	 * 内部系统编号
	 */
	private String internlSysNo;

	/**
	 * 归属部门名称
	 */
	private String belngDeptNm;

	/**
	 * 归属负责人ID
	 */
	private String belngPrincipId;

	/**
	 * 归属负责人姓名
	 */
	private String belngPrincipName;


	public AppSysUnitVo(String tenantsNo, String internlSysNo) {
		this.tenantsNo = tenantsNo;
		this.internlSysNo = internlSysNo;
	}

}
