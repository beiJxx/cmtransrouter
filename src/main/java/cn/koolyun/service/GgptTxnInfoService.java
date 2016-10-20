/*
 * 文 件 名:  GgptTxnInfoService.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.service;

import java.util.List;

import cn.koolyun.model.GgptTxnInfo;
import cn.koolyun.request.TransQueryRequest;

/**
 * <一句话功能简述>
 *  
 * @author  james
 * @version  [V1.00, 2016年10月19日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public interface GgptTxnInfoService {

	public List<GgptTxnInfo> selectByObj(TransQueryRequest ggptTxnInfo);
	
}
