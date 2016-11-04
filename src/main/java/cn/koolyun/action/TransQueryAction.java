/*
 * 文 件 名:  TransQueryAction.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月20日
 */
package cn.koolyun.action;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.koolyun.model.TidMapper;
import cn.koolyun.request.TransQueryRequest;
import cn.koolyun.response.BaseResponse;
import cn.koolyun.response.TransQueryResponse;
import cn.koolyun.service.GgptTxnInfoService;
import cn.koolyun.service.TidMapperService;
import cn.koolyun.util.DateUtil;
import cn.koolyun.util.EncoderUtil;
import cn.koolyun.util.MapBeanUtil;
import cn.koolyun.util.PropertiesUtils;

/**
 * <一句话功能简述>
 * 
 * @author james
 * @version [V1.00, 2016年10月20日]
 * @see [相关类/方法]
 * @since V1.00
 */
@Controller
public class TransQueryAction {

	private static Logger logger = LoggerFactory.getLogger(TransQueryAction.class);
	private static String SIGN_KEY = PropertiesUtils.getProperties("signKey");

	@Autowired
	private GgptTxnInfoService ggptTxnInfoService;
	
	@Autowired
	private TidMapperService tidMapperService;

	@RequestMapping(value = "/transQuery", method = RequestMethod.POST)
	public ResponseEntity<String> transQuery(HttpServletRequest request, @RequestBody String reqParams) {
		logger.info("[transQuery] params=[{}]", reqParams);
		TransQueryRequest req;

		try {
			req = new Gson().fromJson(reqParams, TransQueryRequest.class);
		} catch (Exception e) {
			logger.error("[transQuery] query response: {}" + e.getMessage());
			return baseEntity(new BaseResponse(BaseResponse.FAIL, e.getMessage()));
		}
		if (null == req) {
			logger.error("[transQuery] query response: no any params");
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "no any params"));
		}
		
		// 验签
		Map<String, String> params = null;
		try {
			params = MapBeanUtil.toStringMap(req);
		} catch (Exception e) {
			logger.error("[transQuery] query response: request format error {}" + e.getMessage());
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "验签失败！"));
		}
		String msgSignature = EncoderUtil.encode(EncoderUtil.ALGORITHM_MD5, SIGN_KEY + EncoderUtil.getSortKeyVal2(params));
		logger.info("requestSign: " + req.getSign() + ", mySign: " + msgSignature);
		if (!msgSignature.equals(req.getSign())) {
			logger.error("[transQuery] query response: check sign failed!");
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "验签失败！"));
		}
		
		// 参数检查
		if (StringUtils.isEmpty(req.getCustomerNo())) {
			logger.error("[transQuery] query response: customerNo is missing");
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "customerNo is missing"));
		}
		if (StringUtils.isEmpty(req.getTransBeginDate()) || StringUtils.isEmpty(req.getTransEndDate())) {
			logger.error("[transQuery] query response: query date is missing");
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "query date is missing"));
		}
		if (!DateUtil.validateDateStr(req.getTransBeginDate()) || !DateUtil.validateDateStr(req.getTransEndDate())){
			logger.error("[transQuery] query response: Date format is incorrect, it should be 'yyyMMdd'");
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "Date format is incorrect, it should be 'yyyMMdd'"));
		}

		if(null != req.getPageNo() && null != req.getRecordsPerPage() && (req.getPageNo() <= 0L || req.getRecordsPerPage() <= 0L)){
			logger.error("[transQuery] query response: pageNo or recordsPerPage is incorrect");
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "pageNo or recordsPerPage is incorrect"));
		}
		
		TidMapper byInnerId = tidMapperService.getByInnerId(req.getCustomerNo());
		if (null == byInnerId || !"cpos".equals(byInnerId.getOuterSource()) || !"2".equals(byInnerId.getType())) {
			logger.error("[transQuery] query response: The customer not exist");
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "The customer not exist"));
		}

		try {
			Date beginDate = DateUtil.parse(req.getTransBeginDate());
			Date endDate = DateUtil.parse(req.getTransEndDate());
			if ((null == req.getPageNo() || null == req.getRecordsPerPage()) && DateUtil.getDiffDate(endDate, beginDate) >= 7) {
				logger.error("[transQuery] query response: query date scope over  7 days");
				return baseEntity(new BaseResponse(BaseResponse.FAIL, "query date scope over  7 days"));
			}
		} catch (ParseException e) {
			logger.error("[transQuery] query response: query data wrong {}" + e.getMessage());
			return baseEntity(new BaseResponse(BaseResponse.FAIL, "query data wrong"));
		}

		TransQueryResponse resp = ggptTxnInfoService.findByParams(req);
		if (null == resp.getRecordList()) {
			resp.setReturnCode(BaseResponse.FAIL);
			resp.setReturnMsg("No records");
		} else {
			resp.setReturnCode(BaseResponse.SUCCESS);
			resp.setReturnMsg("success");
		}
		logger.info("[transQuery] query response, resultMsg: {}", resp.getReturnCode() + ", " +resp.getReturnMsg()
		                    +", size:" + ( (resp.getRecordList()==null) ? "0":resp.getRecordList().size()));

		return baseEntity(resp);
	}

	public ResponseEntity<String> baseEntity(BaseResponse resp) {
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("application", "json", Charset.forName("utf-8"));
		headers.setContentType(mediaType);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<String>(gson.toJson(resp), headers, org.springframework.http.HttpStatus.OK);
	}
}
