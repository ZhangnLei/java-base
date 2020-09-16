package mrzhang.base;

/**
 * @author zhangnianlei
 * @date 2020/3/23
 */
public enum RoleEnum {

	REFEREE("1", "主审"),
	ASSISTING("2", "协办"),
	CC("3", "抄送");
	private String value;

	private String description;

	private RoleEnum(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	public static String getDescriptionByValue(String value) {
		for (RoleEnum role : RoleEnum.values()) {
			if (value.equals(role.getValue())) {
				return role.getDescription();
			}
		}
		return null;
	}

}
