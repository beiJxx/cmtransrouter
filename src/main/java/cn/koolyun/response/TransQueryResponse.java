/*
 * 文 件 名:  TransQueryResponse.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.response;

import java.util.List;

import cn.koolyun.response.entity.TransQueryEntity;

/**
 * <一句话功能简述>
 *  
 * @author  james
 * @version  [V1.00, 2016年10月19日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class TransQueryResponse {

	private String totalRecords;
	private String totalPage;
	private List<TransQueryEntity> recordList;
	/**
	 * @return the totalRecords
	 */
	public String getTotalRecords() {
		return totalRecords;
	}
	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(String totalRecords) {
		this.totalRecords = totalRecords;
	}
	/**
	 * @return the totalPage
	 */
	public String getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the recordList
	 */
	public List<TransQueryEntity> getRecordList() {
		return recordList;
	}
	/**
	 * @param recordList the recordList to set
	 */
	public void setRecordList(List<TransQueryEntity> recordList) {
		this.recordList = recordList;
	}
	
	
	
}
