package cn.koolyun.service;

import cn.koolyun.model.TidMapper;

public interface TidMapperService {
	
	TidMapper getByOutId(String outerId, String type, String outerSource);
	
	TidMapper getByInnerId(String innerId);

}
