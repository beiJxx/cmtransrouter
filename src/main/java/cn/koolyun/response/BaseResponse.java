/*
 * 文 件 名:  BaseResponse.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月20日
 */
package cn.koolyun.response;

/**
 * <一句话功能简述>
 *  
 * @author  james
 * @version  [V1.00, 2016年10月20日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class BaseResponse {

	public static final String SUCCESS = "S";
	public static final String FAIL = "E";
	
	private String returnCode = SUCCESS;
	private String returnMsg;
	/**
	 * @return the returnCode
	 */
	public String getReturnCode() {
		return returnCode;
	}
	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	/**
	 * @return the returnMsg
	 */
	public String getReturnMsg() {
		return returnMsg;
	}
	/**
	 * @param returnMsg the returnMsg to set
	 */
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	/** 
	 * <默认构造函数>
	 */
	public BaseResponse(String returnCode, String returnMsg) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}
	/** 
	 * <默认构造函数>
	 */
	public BaseResponse() {
		super();
	}
	
}
