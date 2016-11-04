package cn.koolyun.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties 工具类
 * 
 * @author wangwch
 * @date 2006-8-27
 * @version 1.0
 */
public class PropertiesUtils {

	private static Properties p = null;
	
	public static Properties load() {
		try {
			InputStream in = PropertiesUtils.class.getResourceAsStream("/global.properties");
			p = new Properties();
			p.load(in);
			return p;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String getProperties(String key){
		if(null == p){
			load();
		}
		return p.getProperty(key);
	}
	
	
}
