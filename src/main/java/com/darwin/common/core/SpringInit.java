package com.darwin.common.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * @类描述：spring初始化辅助类，可以再spring初始化时做一些预加载
 * @项目名称：MySolr
 * @包名： com.darwin.common.core
 * @类名称：SpringInit
 * @创建人：WangDong
 * @创建时间：2018年7月23日上午2:25:58
 * @修改人：WangDong
 * @修改时间：2018年7月23日上午2:25:58
 * @修改备注：
 * @version v1.0
 * @see 
 * @bug 
 * @Copyright 
 * @mail *@qq.com
 */
public class SpringInit implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object obj, String arg1) throws BeansException {
		/**
		 * do something before spring init
		 */
		return obj;
	}

	public Object postProcessAfterInitialization(Object obj, String arg1) throws BeansException {
		/**
		 * do something after spring init
		 */
		return obj;
	} 
}
