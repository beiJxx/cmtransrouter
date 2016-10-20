/*
 * 文 件 名:  GgptTxnInfoServiceImpl.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.koolyun.dao.inter.GgptTxnInfoMapper;
import cn.koolyun.model.GgptTxnInfo;
import cn.koolyun.model.GgptTxnInfoExample;
import cn.koolyun.request.TransQueryRequest;
import cn.koolyun.service.GgptTxnInfoService;

/**
 * <一句话功能简述>
 *  
 * @author  james
 * @version  [V1.00, 2016年10月19日]
 * @see  [相关类/方法]
 * @since V1.00
 */
@Service
public class GgptTxnInfoServiceImpl implements GgptTxnInfoService{
	
	@Resource
	private GgptTxnInfoMapper mapper;

	/**
	 * 重写方法
	 * @param ggptTxnInfo
	 * @return
	 * @see cn.koolyun.service.GgptTxnInfoService#selectByObj(cn.koolyun.model.GgptTxnInfo)
	 */
	public List<GgptTxnInfo> selectByObj(TransQueryRequest ggptTxnInfo) {
		GgptTxnInfoExample example = new GgptTxnInfoExample();
		example.createCriteria().andMchtCdEqualTo(ggptTxnInfo.getCustomerNo())
					.andTermIdEqualTo(ggptTxnInfo.getDeviceId());
		List<GgptTxnInfo> selectByExample = mapper.selectByExample(example);
		return selectByExample;
	}

}
