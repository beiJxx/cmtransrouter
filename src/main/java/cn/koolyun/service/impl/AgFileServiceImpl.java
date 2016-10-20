/*
 * 文 件 名:  AgFileServiceImpl.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.koolyun.dao.chps.AgFileMapper;
import cn.koolyun.service.AgFileService;

/**
 * <一句话功能简述>
 *  
 * @author  james
 * @version  [V1.00, 2016年10月19日]
 * @see  [相关类/方法]
 * @since V1.00
 */
@Service
public class AgFileServiceImpl implements AgFileService{

	@Resource
	private AgFileMapper mapper;

	/**
	 * 重写方法
	 * @return
	 * @see cn.koolyun.service.AgFileService#count()
	 */
	public int count() {
		return mapper.countByExample(null);
	}
	

	
	
}
