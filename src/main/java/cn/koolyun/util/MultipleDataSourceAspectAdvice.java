/*
 * 文 件 名:  MultipleDataSourceAspectAdvice.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年10月19日
 */
package cn.koolyun.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * <一句话功能简述>
 * 
 * @author james
 * @version [V1.00, 2016年10月19日]
 * @see [相关类/方法]
 * @since V1.00
 */
@Component
@Aspect
public class MultipleDataSourceAspectAdvice {

	@Around("execution(* cn.koolyun.dao.inter..*.*(*))")
	public Object doAround1(ProceedingJoinPoint jp) throws Throwable {
		MultipleDataSource.setDataSourceKey("dataSourceInter");
		return jp.proceed();
	}

	@Around("execution(* cn.koolyun.dao.chps..*.*(*))")
	public Object doAround2(ProceedingJoinPoint jp) throws Throwable {
		MultipleDataSource.setDataSourceKey("dataSourceChps");
		return jp.proceed();
	}
}
