package cn.koolyun.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapBeanUtil {

	public static final Object toBean(Class<?> type, Map<String, ? extends Object> map)   
            throws IntrospectionException, IllegalAccessException,  InstantiationException, InvocationTargetException {  
        BeanInfo beanInfo = Introspector.getBeanInfo(type);  
        Object obj = type.newInstance();  
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
        for (int i = 0; i< propertyDescriptors.length; i++) {  
            PropertyDescriptor descriptor = propertyDescriptors[i];  
            String propertyName = descriptor.getName();  
            if (map.containsKey(propertyName)) {  
                Object value = map.get(propertyName);  
                Object[] args = new Object[1];  
                args[0] = value;  
                descriptor.getWriteMethod().invoke(obj, args);  
            }  
        }  
        return obj;  
    }  
      
    /** 
     * Converts a JavaBean to a map. 
     *  
     * @param bean JavaBean to convert 
     * @return map converted 
     * @throws IntrospectionException failed to get class fields 
     * @throws IllegalAccessException failed to instant JavaBean 
     * @throws InvocationTargetException failed to call setters 
     */  
    public static final Map<String, Object> toMap(Object bean)   throws IntrospectionException, IllegalAccessException, InvocationTargetException {  
        Map<String, Object> returnMap = new HashMap<String, Object>();  
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());  
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
        for (int i = 0; i< propertyDescriptors.length; i++) {  
            PropertyDescriptor descriptor = propertyDescriptors[i];  
            String propertyName = descriptor.getName();  
            if (!propertyName.equals("class")) {  
                Method readMethod = descriptor.getReadMethod();  
                Object result = readMethod.invoke(bean, new Object[0]);  
                if (result != null) {  
                    returnMap.put(propertyName, result);  
                } else {  
                    returnMap.put(propertyName, "");  
                }  
            }  
        }  
        return returnMap;  
    }  

    /** 
     * Converts a JavaBean to a Map<String, String>. 
     *  
     * @param bean JavaBean to convert 
     * @return map converted 
     * @throws IntrospectionException failed to get class fields 
     * @throws IllegalAccessException failed to instant JavaBean 
     * @throws InvocationTargetException failed to call setters 
     */  
    public static final Map<String, String> toStringMap(Object bean)   throws IntrospectionException, IllegalAccessException, InvocationTargetException {  
        Map<String, String> returnMap = new HashMap<String, String>();  
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());  
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
        for (int i = 0; i< propertyDescriptors.length; i++) {  
            PropertyDescriptor descriptor = propertyDescriptors[i];  
            String propertyName = descriptor.getName();  
            if (!propertyName.equals("class")) {  
                Method readMethod = descriptor.getReadMethod();  
                Object result = readMethod.invoke(bean, new Object[0]);  
                if (result != null) {  
                    returnMap.put(propertyName, result.toString());  
                } else {  
                    returnMap.put(propertyName, "");  
                }  
            }  
        }  
        return returnMap;  
    }  
}
