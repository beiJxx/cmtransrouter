/*
 * 文 件 名:  Test.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.koolyun.model.GgptTxnInfo;
import cn.koolyun.request.TransQueryRequest;
import cn.koolyun.service.AgFileService;
import cn.koolyun.service.GgptTxnInfoService;

/**
 * <一句话功能简述>
 *  
 * @author  james
 * @version  [V1.00, 2016年10月19日]
 * @see  [相关类/方法]
 * @since V1.00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {

	@Autowired
	private GgptTxnInfoService ggptTxnInfoService;
	
	@Autowired
	private AgFileService agFileService;
	
	@org.junit.Test
	public void test() {
		int countByExample = agFileService.count();
		System.out.println(countByExample);
		System.out.println("==================================");
		
		TransQueryRequest req = new TransQueryRequest();
		req.setCustomerNo("999290053110041");
		req.setDeviceId("00000054");
		List<GgptTxnInfo> selectByObj = ggptTxnInfoService.selectByObj(req);
		for (GgptTxnInfo ggptTxnInfo : selectByObj) {
			System.out.println(ggptTxnInfo.getOperator());
		}
	}

}
