package com.darwin.common.core;

import com.darwin.common.utils.MyProperty;


/**
 * @类描述：常量缓存
 * @项目名称：MySolr
 * @包名： com.darwin.common.core
 * @类名称：Constant
 * @创建人：WangDong
 * @创建时间：2018年7月23日上午2:25:42
 * @修改人：WangDong
 * @修改时间：2018年7月23日上午2:25:42
 * @修改备注：
 * @version v1.0
 * @see 
 * @bug 
 * @Copyright 
 * @mail *@qq.com
 */
public class Constant {
	
	public static final String SOLR_URL = MyProperty.getProperty("solr_url");
	
	public static final String SOLR_CORE = String.valueOf(MyProperty.getProperty("solr_core"));

}
