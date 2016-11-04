/*
 * 文 件 名:  GgptTxnInfoServiceImpl.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.koolyun.response.BaseResponse;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.koolyun.dao.inter.GgptTxnInfoMapper;
import cn.koolyun.dao.inter.TdatDictMapper;
import cn.koolyun.dao.inter.TidMapperMapper;
import cn.koolyun.dao.inter.TmerInfoMapper;
import cn.koolyun.dao.inter.TpaymentMapper;
import cn.koolyun.model.GgptTxnInfo;
import cn.koolyun.model.GgptTxnInfoExample;
import cn.koolyun.model.GgptTxnInfoExample.Criteria;
import cn.koolyun.model.TdatDict;
import cn.koolyun.model.TdatDictExample;
import cn.koolyun.model.TidMapper;
import cn.koolyun.model.TidMapperExample;
import cn.koolyun.model.TmerInfo;
import cn.koolyun.model.TmerInfoExample;
import cn.koolyun.request.TransQueryRequest;
import cn.koolyun.response.TransQueryResponse;
import cn.koolyun.response.entity.TransQueryEntity;
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
	@Autowired
	private TdatDictMapper dictMapper;
	@Autowired
	private TpaymentMapper payMapper;
	@Autowired
	private TidMapperMapper idMapper;
	@Autowired
	private TmerInfoMapper merMapper;
	
	private static Map<String, String> transStatus = new HashMap<String, String>(); 
	private static Map<String, String> chnlClass = new HashMap<String, String>();
	private static Map<String, String> mchtInfo = new HashMap<String, String>();
	
	/**
	 * 重写方法
	 * @param ggptTxnInfo
	 * @return
	 * @see cn.koolyun.service.GgptTxnInfoService#selectByObj(cn.koolyun.model.GgptTxnInfo)
	 */
	public List<GgptTxnInfo> selectByObj(TransQueryRequest queryReq) {
		GgptTxnInfoExample example = new GgptTxnInfoExample();
		example.createCriteria().andMchtCdEqualTo(queryReq.getCustomerNo()).andTermIdEqualTo(queryReq.getDeviceId());
		List<GgptTxnInfo> selectByExample = mapper.selectByExample(example);
		return selectByExample;
	}

	
	public TransQueryResponse findByParams(TransQueryRequest queryReq) {
		GgptTxnInfoExample example = new GgptTxnInfoExample();
		Criteria c = example.createCriteria().andMchtCdEqualTo(queryReq.getCustomerNo()).andInstDateBetween(queryReq.getTransBeginDate(), queryReq.getTransEndDate());
		if (!StringUtils.isEmpty(queryReq.getCustomerOrderId())) {
			c.andOdNoEqualTo(queryReq.getCustomerOrderId());
		}
		if (!StringUtils.isEmpty(queryReq.getDeviceId())) {
			c.andTermIdEqualTo(queryReq.getDeviceId());
		}
		// transType    // 1021  消费， 3021消费撤销， 1031预授权完成， 3051退货
		if (!StringUtils.isEmpty(queryReq.getTransType())) {
			c.andTxnNumEqualTo(queryReq.getTransType());
		}
		// transChannel   //  ZFB,  WX,  QQ, FFTBANK, QBBANK   ,HSBANK
		if (!StringUtils.isEmpty(queryReq.getTransChannel())) {
			String payKey = null;
			if ("ZFB".equalsIgnoreCase(queryReq.getTransChannel())) {
				payKey = "CPOS_CMSZ_ALIPAY_%_PAYID";
			}else if ("WX".equalsIgnoreCase(queryReq.getTransChannel())) {
				payKey = "CPOS_CMSZ_WEIXIN_%_PAYID";
			}else if ("QQ".equalsIgnoreCase(queryReq.getTransChannel())) {
				payKey = "CPOS_QQ_%_PAYID";
			}else if ("FFTBANK".equalsIgnoreCase(queryReq.getTransChannel())) {
				payKey = "CPOS_FFTS_%_PAYID";
			}else if ("QBBANK".equalsIgnoreCase(queryReq.getTransChannel())) {
				payKey = "CPOS_QBZX_%_PAYID";
			}else if ("HSBANK".equalsIgnoreCase(queryReq.getTransChannel())) {
				payKey = "CPOS_HSXX_%_PAYID";
			}
			TdatDictExample dexample = new TdatDictExample();
			dexample.createCriteria().andDataKindEqualTo("1").andDataTypeEqualTo("0000").andDataCdLike(payKey);
			List<TdatDict> list = dictMapper.selectByExample(dexample);
			List<String> payIdlist = new ArrayList<String>();
			if (list != null && list.size() > 0) {
				for(TdatDict dict : list) {
					payIdlist.add(dict.getDataNm());
				}
			}
			if (payIdlist.isEmpty()) {
				payIdlist.add("-1");
			}
			c.andPayIdIn(payIdlist);
		}
		example.setOrderByClause(" CREATE_TIMESTAMP desc");
		int count = mapper.countByExample(example);
		List<GgptTxnInfo> infolist =  null;
		TransQueryResponse response = new TransQueryResponse();
		if (queryReq.getPageNo() != null && queryReq.getRecordsPerPage() != null) {
			RowBounds rowBounds = new RowBounds((queryReq.getPageNo().intValue() - 1) *  queryReq.getRecordsPerPage().intValue(), queryReq.getRecordsPerPage().intValue());
			infolist = mapper.selectByExampleWithBounds(example, rowBounds);
			response.setTotalPage((long) ((count+queryReq.getRecordsPerPage().intValue()-1)/queryReq.getRecordsPerPage().intValue()));
		}else{
			infolist = mapper.selectByExample(example);
		}
		response.setTotalRecords((long) count);
		if (infolist == null) {
			return response;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<TransQueryEntity> recordList = new ArrayList<TransQueryEntity>(infolist.size());
		for(GgptTxnInfo info : infolist) {
			TransQueryEntity entity = new TransQueryEntity();
			entity.setCustomerId(info.getMchtCd());
			entity.setDeviceId(info.getTermId());
			entity.setCustomerName(getMchtName(info.getMchtCd()));
			entity.setCustomerOrderId(info.getOdNo());
			if (!StringUtils.isEmpty(queryReq.getTransChannel())) {
				entity.setTransChannel(queryReq.getTransChannel());
			}else{
				entity.setTransChannel(getChnlName(info.getPayId()));
			}
			// 钱包机构有，收单机构无
			if ("ZFB".equals(entity.getTransChannel()) || "WX".equals(entity.getTransChannel()) || "QQ".equals(entity.getTransChannel())) {
				entity.setChannelOrderId(info.getChnlRefNo());
			}
			entity.setTransAmount(multipl(info.getAmount(), 100));
			entity.setTransType(info.getTxnNum());
			// 银行卡有该字段
			entity.setMerchantId(info.getChnlMchtCd());
			// 银行卡有该字段
			if (!StringUtils.isEmpty(queryReq.getDeviceId())) {
				entity.setPosId(queryReq.getDeviceId());
			}else{
				entity.setPosId(getPosId(info.getTermId()));
			}
			// 收单参考号或钱包流水号
			// 收单 批次号+流水号，  钱包：机构参考号
			if ("ZFB".equals(entity.getTransChannel()) || "WX".equals(entity.getTransChannel()) || "QQ".equals(entity.getTransChannel())) {
				entity.setTransNo(info.getChnlRefNo());
			}else{
				entity.setTransNo(info.getBatchNo()+info.getInstTrace());
			}
			entity.setTransAccount(info.getCardNo());
			// 收单位卡号，钱包（支付宝）为买家账号，其他钱包支付无该字段
			entity.setTransTime(sdf.format(info.getCreateTimestamp()));
			entity.setTransStatus(getTranStat(info.getTxnStat()));
			recordList.add(entity);
		}
		response.setRecordList(recordList);
		return response;
	}
	
	private String getMchtName(String mchtCd) {
		if (mchtCd == null || mchtCd.equals("")) return mchtCd;
		if (mchtInfo.containsKey(mchtCd)) {
			return mchtInfo.get(mchtCd);
		}
		
		TmerInfoExample example = new TmerInfoExample();
		example.createCriteria().andMerIdEqualTo(mchtCd).andStaEqualTo("0").andChkStaEqualTo("0");
		 List<TmerInfo> list = merMapper.selectByExample(example);
		 if (list != null && list.size() > 0) {
			 mchtInfo.put(mchtCd, list.get(0).getMerNm());
			 return list.get(0).getMerNm();
		 }
		 return "";
	}
	
	// 根据内部终端号，返回cpos的终端号
	private String getPosId(String termId) {
		if (termId == null || termId.equals("")) return termId;
		if (mchtInfo.containsKey("pos"+termId)) {
			return mchtInfo.get("pos"+termId);
		}
		
		TidMapperExample example = new TidMapperExample();
		example.createCriteria().andInterIdEqualTo(termId).andOuterSourceEqualTo("cpos");
		List<TidMapper> list = idMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			mchtInfo.put("pos"+termId, list.get(0).getOuterId());
			return list.get(0).getOuterId();
		}
		return null;
	}


	private String getChnlName(String payId) {
		if (payId == null || payId.equals("")) return payId;
		if (chnlClass.containsKey(payId)) {
			return chnlClass.get(payId);
		}
		
		String chnlClass = "";
		TdatDictExample dexample = new TdatDictExample();
		dexample.createCriteria().andDataKindEqualTo("1").andDataTypeEqualTo("0000").andDataNmEqualTo(payId);
		List<TdatDict> list = dictMapper.selectByExample(dexample);
		if (list != null && list.size() >0) {
			if (list.get(0).getDataCd().contains("CPOS") && list.get(0).getDataCd().contains("ALIPAY")) {
				chnlClass = "ZFB";
			}else if (list.get(0).getDataCd().contains("CPOS") && list.get(0).getDataCd().contains("WEIXIN")) {
				chnlClass = "WX";
			}else if (list.get(0).getDataCd().contains("CPOS") && list.get(0).getDataCd().contains("QQ")) {
				chnlClass = "QQ";
			}else if (list.get(0).getDataCd().contains("CPOS") && list.get(0).getDataCd().contains("FFTS")) {
				chnlClass = "FFTBANK";
			}else if (list.get(0).getDataCd().contains("CPOS") && list.get(0).getDataCd().contains("QBZX")) {
				chnlClass = "QBBANK";
			}else if (list.get(0).getDataCd().contains("CPOS") && list.get(0).getDataCd().contains("HSXX")) {
				chnlClass = "HSBANK";
			}
		}
		return chnlClass;
	}
	
	private String getTranStat(String txtstat) {
		if (txtstat == null || txtstat.equals("")) return txtstat;
		if (transStatus.containsKey(txtstat)) {
			return transStatus.get(txtstat);
		}
		
		TdatDictExample dexample = new TdatDictExample();
		dexample.createCriteria().andDataKindEqualTo("3").andDataTypeEqualTo("0002").andDataCdEqualTo(txtstat);
		List<TdatDict> list = dictMapper.selectByExample(dexample);
		if (list != null && list.size() > 0) {
			transStatus.put(txtstat, list.get(0).getDataNm());
			return list.get(0).getDataNm();
		}
		return txtstat;
	}
	
	private String multipl(String org, int times) {
		if (org == null || org.equals("")) {
			return org;
		}
		BigDecimal bigDecimal = new BigDecimal(org.trim());
		bigDecimal = bigDecimal.multiply(new BigDecimal(times)).setScale(2, BigDecimal.ROUND_HALF_UP);
		return bigDecimal.toString();
	}
	
	public int countByParams(TransQueryRequest ggptTxnInfo) {
		GgptTxnInfoExample example = new GgptTxnInfoExample();
		return mapper.countByExample(example);
	}
}
