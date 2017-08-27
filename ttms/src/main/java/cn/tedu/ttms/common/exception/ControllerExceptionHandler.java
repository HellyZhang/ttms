package cn.tedu.ttms.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.entity.JSONResult;

/**
 * 此注解用于标识类为全局的异常处理类
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	@ResponseBody
	public JSONResult HandleException(NullPointerException e) {
		//可以添加一些异常处理逻辑
		return new JSONResult(e);
	}

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseBody
	public JSONResult HandleException(RuntimeException e) {
		return new JSONResult(e);
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JSONResult HandleException(Exception e) {
		return new JSONResult(e);
	}
}
