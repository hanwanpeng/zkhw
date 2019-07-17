package com.zkhw.common.enums;

/**
 * 统一状态码
 * @author houmeng
 *
 */
public enum StatusCodeEnum {
	SUCCESS("0", "成功"),
	FAIL("1","失败"),
	
	LOGIN_FAIL("10001", "登录失败,用户名或密码不正确"),
	USER_ADD_FAIL("10002", "添加用户失败"),
	USER_UPDATE_FAIL("10003", "修改用户失败"),
	USER_SEARCH("10004", "用户查询失败");
	
	
	private StatusCodeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	private String code;
	private String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static StatusCodeEnum getByCode(String code){
		code=code.trim();
		for (StatusCodeEnum statusCodeEnum : StatusCodeEnum.values()) {
			String tempName = statusCodeEnum.getCode();
			if (code.equals(tempName)) {
				return statusCodeEnum;
			}
		}
		return null;
	}	
}
