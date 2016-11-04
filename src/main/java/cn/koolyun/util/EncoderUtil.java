package cn.koolyun.util;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncoderUtil {

	public static final String ALGORITHM_MD5 = "MD5";
	public static final String ALGORITHM_SHA1 = "SHA1";
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	private static Logger logger = LoggerFactory.getLogger(EncoderUtil.class);
	
	/**
     * encode string
     *
     * @param algorithm
     * @param str
     * @return String
     */
	public static String encode(String algorithm, String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	/**
     * encode string
     *
     * @param algorithm
     * @param str
     * @param key
     * @return String
     */
	public static String encode(String algorithm, String str, String key) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest(key.getBytes("UTF8")));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Takes the raw bytes from the digest and formats them correct.
	 * 
	 * @param bytes
	 *            the raw bytes from the digest.
	 * @return the formatted bytes.
	 */
	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		// 把密文转换成十六进制的字符串形式
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}
		return buf.toString().toUpperCase();
	}
	
	public static String getSortVal(Map<String, String> map) {
		TreeMap<String, String> sortMap = new TreeMap<String, String>();
		sortMap.putAll(map);
		Set<String> keySet = sortMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		StringBuffer buffer = new StringBuffer();
		while (iterator.hasNext()) {
			String key = iterator.next();
			buffer.append(sortMap.get(key));
		}
		logger.debug("[getSortVal] 排序后拼接字串:{}", buffer);
		return buffer.toString();
	}
	
	public static String getSortKeyVal(Map<String, String> map) {
		TreeMap<String, String> sortMap = new TreeMap<String, String>();
		sortMap.putAll(map);
		Set<String> keySet = sortMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		StringBuffer buffer = new StringBuffer();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = sortMap.get(key);
			// 排除 sign 字段， 或者 值为空 （null, ''）
			if ("sign".equals(key) ||  (value == null || "".equals(value))) {
				continue;
			}
			buffer.append(key+"="+value);
			buffer.append("&");
		}
		buffer.setLength(buffer.length()-1);
		logger.debug("[getSortKeyVal] 排序后拼接字串:{}", buffer);
		return buffer.toString();
	}
	
	public static String getSortKeyVal2(Map<String, String> map) {
		TreeMap<String, String> sortMap = new TreeMap<String, String>();
		sortMap.putAll(map);
		Set<String> keySet = sortMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		StringBuffer buffer = new StringBuffer();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = sortMap.get(key);
			// 排除 sign 字段， 或者 值为空 （null, ''）
			if ("sign".equals(key) ||  (value == null || "".equals(value))) {
				continue;
			}
			buffer.append(key+sortMap.get(key));
		}
		logger.debug("[getSortKeyVal2] 排序后拼接字串:{}", buffer);
		return buffer.toString();
	}
	
	 public static void main(String[] args) {
		 System.out.println( EncoderUtil.encode(EncoderUtil.ALGORITHM_MD5, "hello,world") );
		 System.out.println( EncoderUtil.encode(EncoderUtil.ALGORITHM_SHA1, "hello,world") );
	 }
}
