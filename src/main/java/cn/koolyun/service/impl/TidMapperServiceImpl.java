package cn.koolyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.koolyun.dao.inter.TidMapperMapper;
import cn.koolyun.model.TidMapper;
import cn.koolyun.model.TidMapperExample;
import cn.koolyun.service.TidMapperService;

@Service
public class TidMapperServiceImpl implements TidMapperService {

	@Autowired
	private TidMapperMapper mapper;
	
	public TidMapper getByOutId(String outerId, String type, String outerSource) {
		TidMapperExample example = new TidMapperExample();
		example.createCriteria().andOuterIdEqualTo(outerId).andTypeEqualTo(type).andOuterSourceEqualTo(outerSource);
		List<TidMapper> list =  mapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public TidMapper getByInnerId(String innerId) {
		TidMapperExample example = new TidMapperExample();
		example.createCriteria().andInterIdEqualTo(innerId);
		List<TidMapper> list =  mapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
