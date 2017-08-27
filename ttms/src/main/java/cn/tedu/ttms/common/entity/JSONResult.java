package cn.tedu.ttms.common.entity;

/**
 * 封装控制层返回的JSON结果 便于统一对控制层返回数据进行统一管理
 * 
 */

public class JSONResult {
	public static final int SUCCESS = 1;
	public static final int ERROR = 0;
	/** 服务状态 */
	private int state;
	/** 提示给用户的信息 */
	private String message;
	/** 具体业务数据 */
	private Object data;

	public JSONResult() {
		super();
		state = SUCCESS;
		message = "ok";
	}

	public JSONResult(Object obj) {
		this();
		data = obj;
	}

	public JSONResult(Throwable e) {
		this.state = ERROR;
		this.message = e.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
