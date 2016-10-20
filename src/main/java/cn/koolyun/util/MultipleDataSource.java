/*
 * 文 件 名:  MultipleDataSource.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <一句话功能简述>
 *  
 * @author  james
 * @version  [V1.00, 2016年10月19日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
	
	/**
	 * 重写方法
	 * @return
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return dataSourceKey.get();
	}

}
