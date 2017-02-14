package cn.fictio.springboot.common;

public class ResponseBody {
	
	private int code = 0;
	private Object obj;
	
	public void setSucess(){
		this.code = 1;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
