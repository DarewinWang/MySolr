package com.darwin.common.core;


/**
 * @类描述：定义Response返回对象
 * @项目名称：MySolr
 * @包名： com.darwin.common.core
 * @类名称：ResponseResult
 * @创建人：WangDong
 * @创建时间：2018年7月23日上午1:53:04
 * @修改人：WangDong
 * @修改时间：2018年7月23日上午1:53:04
 * @修改备注：
 * @version v1.0
 * @see 
 * @bug 
 * @Copyright 
 * @mail *@qq.com
 */
public class ResponseResult {
	
	/**
	 * @字段：code
	 * @功能描述：返回状态码
	 * @创建人：WangDong
	 * @创建时间：2018年7月23日上午1:53:32
	 */
	private int code;
	
	/**
	 * @字段：data
	 * @功能描述：返回数据
	 * @创建人：WangDong
	 * @创建时间：2018年7月23日上午1:53:47
	 */
	private Object data;
	
	/**
	 * @字段：msg
	 * @功能描述：附加返回信息
	 * @创建人：WangDong
	 * @创建时间：2018年7月23日上午1:53:58
	 */
	private String msg;
	
	public ResponseResult() {
		super();
	}

	public ResponseResult(int code, Object data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResponseResult [code=" + code + ", data=" + data + ", msg=" + msg + "]";
	}

}
