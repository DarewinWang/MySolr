package com.darwin.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


/**
 * @类描述：用于Spring启动时加载配置文件，生成Key-Value
 * @项目名称：MySolr
 * @包名： com.darwin.common.utils
 * @类名称：MyProperty
 * @创建人：WangDong
 * @创建时间：2018年7月23日上午12:37:21
 * @修改人：WangDong
 * @修改时间：2018年7月23日上午12:37:21
 * @修改备注：
 * @version v1.0
 * @see 
 * @bug 
 * @Copyright 
 * @mail *@qq.com
 */
public class MyProperty extends PropertyPlaceholderConfigurer {
	
	/**
	 * @字段：propertyMap
	 * @功能描述：配置文件Map
	 * @创建人：WangDong
	 * @创建时间：2018年7月23日上午12:37:05
	 */
	private static Map<String, String> propertyMap;

	
    /**
     * @描述:获取配置文件
     * @方法名: getProperty
     * @param name
     * @return
     * @返回类型 String
     * @创建人 WangDong
     * @创建时间 2018年7月23日上午12:24:18
     * @修改人 WangDong
     * @修改时间 2018年7月23日上午12:24:18
     * @修改备注
     * @since
     * @throws
     */
    public static String getProperty(String name) {
        return propertyMap.get(name);
    }
    
    
    /**
     * @描述:加载配置文件
     * @方法名: processProperties
     * @param beanFactoryToProcess
     * @param props
     * @throws BeansException
     * @创建人：WangDong
     * @创建时间：2018年7月23日上午12:36:31
     * @修改人：WangDong
     * @修改时间：2018年7月23日上午12:36:31
     * @修改备注：
     * @throws
     */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertyMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
    }
   
}
