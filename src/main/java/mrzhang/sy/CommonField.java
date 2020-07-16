package mrzhang.sy;

import lombok.Data;

import java.io.Serializable;


/**
 * 实体基类
 *
 */
@Data
public class CommonField implements Serializable {

	private static final long serialVersionUID = 7190522492401710874L;

	/**
	 * 有效标志
	 */
	public String validFlg;

	/**
	 * 新增人ID
	 */
	private String createrId;

	/**
	 * 新增人姓名
	 */
	private String createrName;

	/**
	 * 新增时间
	 */
	private String crtTm;

	/**
	 * 修改人ID
	 */
	private String modifierId;

	/**
	 * 修改人姓名
	 */
	private String modifierName;

	/**
	 * 修改时间
	 */
	private String modfyTm;

}
