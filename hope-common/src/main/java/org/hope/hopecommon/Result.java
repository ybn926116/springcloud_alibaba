package org.hope.hopecommon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;


    public static <T> Result<T> success(T data){
        return new Result<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(String message,T data){
        return new Result<T>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> failed(){
        return new Result<T>(ResultEnum.COMMON_FAILED.getCode(), ResultEnum.COMMON_FAILED.getMessage(), null);
    }

    public static <T> Result<T> failed(String message){
        return new Result<T>(ResultEnum.COMMON_FAILED.getCode(), message, null);
    }

    public static <T> Result<T> failed(IResult error){
        return new Result<T>(error.getCode(), error.getMessage(), null);
    }

    public static <T> Result<T> instance(Integer code, String message, T data) {
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setMessage(message);
		result.setData(data);
		return result;
	}

}
