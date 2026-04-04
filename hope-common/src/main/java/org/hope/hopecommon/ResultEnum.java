package org.hope.hopecommon;

import lombok.Data;

public enum ResultEnum implements IResult {
    /**
	 * return success result.
	 */
	SUCCESS(2001, "接口调用成功"),
	/**
	 * return business common failed.
	 */
	COMMON_FAILED(2003, "接口调用失败");

    private int code;
    private String message;
    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    ResultEnum() {
    }
    @Override
    public Integer getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
