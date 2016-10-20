/*
 * 文 件 名:  TransQueryRequest.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.request;

/**
 * <一句话功能简述>
 *  
 * @author  james
 * @version  [V1.00, 2016年10月19日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class TransQueryRequest {

	//传一个订单号，表示查一个订单的交易；不传，表示所有符合条件的订单
	private String customerOrderId;
	//客户号
	private String customerNo;
	//设备号
	private String deviceId;
	//交易类型（消费|撤销|退货|预授权，不传表示所有）
	private String transType;
	//查询开始日期  格式20160829
	private String transBeginDate;
	//查询结束日期  格式20160829
	private String transEndDate;
	
	
	//每页显示条数
	private String recordsPerPage;
	//页号（第一次传1）
	private String pageNo;
	/**
	 * @return the customerOrderId
	 */
	public String getCustomerOrderId() {
		return customerOrderId;
	}
	/**
	 * @param customerOrderId the customerOrderId to set
	 */
	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	/**
	 * @return the customerNo
	 */
	public String getCustomerNo() {
		return customerNo;
	}
	/**
	 * @param customerNo the customerNo to set
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the transType
	 */
	public String getTransType() {
		return transType;
	}
	/**
	 * @param transType the transType to set
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}
	/**
	 * @return the transBeginDate
	 */
	public String getTransBeginDate() {
		return transBeginDate;
	}
	/**
	 * @param transBeginDate the transBeginDate to set
	 */
	public void setTransBeginDate(String transBeginDate) {
		this.transBeginDate = transBeginDate;
	}
	/**
	 * @return the transEndDate
	 */
	public String getTransEndDate() {
		return transEndDate;
	}
	/**
	 * @param transEndDate the transEndDate to set
	 */
	public void setTransEndDate(String transEndDate) {
		this.transEndDate = transEndDate;
	}
	/**
	 * @return the recordsPerPage
	 */
	public String getRecordsPerPage() {
		return recordsPerPage;
	}
	/**
	 * @param recordsPerPage the recordsPerPage to set
	 */
	public void setRecordsPerPage(String recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	/**
	 * @return the pageNo
	 */
	public String getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
}
