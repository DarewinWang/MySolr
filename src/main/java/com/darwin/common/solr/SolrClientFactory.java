package com.darwin.common.solr;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrException;

import com.darwin.common.core.Constant;


/**
 * @类描述：获取solr连接静态工厂
 * @项目名称：MySolr
 * @包名： com.darwin.common.solr
 * @类名称：SolrClientFactory
 * @创建人：WangDong
 * @创建时间：2018年7月23日上午1:48:59
 * @修改人：WangDong
 * @修改时间：2018年7月23日上午1:48:59
 * @修改备注：
 * @version v1.0
 * @see 
 * @bug 
 * @Copyright 
 * @mail *@qq.com
 */
public class SolrClientFactory {
	private static Logger LOGGER = LogManager.getLogger(SolrClientFactory.class);
	
	
	/**
	 * @描述:获取连接实例
	 * @方法名: getClient
	 * @return
	 * @返回类型 SolrClient
	 * @创建人 WangDong
	 * @创建时间 2018年7月23日上午1:49:25
	 * @修改人 WangDong
	 * @修改时间 2018年7月23日上午1:49:25
	 * @修改备注
	 * @since
	 * @throws
	 */
	public static SolrClient getClient() {
		String url = Constant.SOLR_URL + Constant.SOLR_CORE;
		SolrClient solr = null;
		try{
			solr = new HttpSolrClient.Builder(url)
					.withConnectionTimeout(10000)
					.withSocketTimeout(60000).build();
		}catch (SolrException e) {
			LOGGER.error(e.getMessage());
		}
		return solr;		
	}
	
	
	/**
	 * @描述:关闭solr连接
	 * @方法名: close
	 * @param client
	 * @return
	 * @返回类型 boolean
	 * @创建人 WangDong
	 * @创建时间 2018年7月23日上午1:49:37
	 * @修改人 WangDong
	 * @修改时间 2018年7月23日上午1:49:37
	 * @修改备注
	 * @since
	 * @throws
	 */
	public static boolean close(SolrClient client) {
		if(null != client) {
			try {
				client.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
				return false;
			}
			return true;
		}
		return false;
	}

}
