package com.darwin.controller;

import java.io.IOException;
import java.util.LinkedList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darwin.common.core.ResponseResult;
import com.darwin.common.solr.SolrClientFactory;


/**
 * @类描述：solr搜索相关的Controller
 * @项目名称：MySolr
 * @包名： com.darwin.controller
 * @类名称：SearchController
 * @创建人：WangDong
 * @创建时间：2018年7月23日上午2:28:24
 * @修改人：WangDong
 * @修改时间：2018年7月23日上午2:28:24
 * @修改备注：
 * @version v1.0
 * @see 
 * @bug 
 * @Copyright 
 * @mail *@qq.com
 */
@Controller
@RequestMapping("/search")
public class SearchController {
	private static Logger LOGGER = LogManager.getLogger(SearchController.class);
	
	
	/**
	 * @描述:主搜索方法
	 * @方法名: search
	 * @return
	 * @返回类型 ResponseResult
	 * @创建人 WangDong
	 * @创建时间 2018年7月23日上午2:28:53
	 * @修改人 WangDong
	 * @修改时间 2018年7月23日上午2:28:53
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/search")
	@ResponseBody
	public ResponseResult search() {
		SolrClient sc = SolrClientFactory.getClient();
		SolrQuery query = new SolrQuery();
		
		query.setQuery("id:*");
        query.setRows(20);

        QueryResponse response = null;
		try {
			response = sc.query(query);
		} catch (SolrServerException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage());
		}

        SolrDocumentList documents = response.getResults();
		return new ResponseResult(200, documents, "success");
	}
	
	
	/**
	 * @描述:创建索引方法
	 * @方法名: indexing
	 * @return
	 * @返回类型 ResponseResult
	 * @创建人 WangDong
	 * @创建时间 2018年7月23日上午2:29:08
	 * @修改人 WangDong
	 * @修改时间 2018年7月23日上午2:29:08
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/indexing")
	@ResponseBody
	public ResponseResult indexing() {
		SolrClient sc = SolrClientFactory.getClient();
		
		try {
			sc.add(makeDocs());
			sc.commit();
		} catch (SolrServerException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage());
		}
		return new ResponseResult(200, true, "success");
	}
	
	private LinkedList<SolrInputDocument> makeDocs(){
		LinkedList<SolrInputDocument> docs = new LinkedList<>();
		
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "123");
		
		docs.add(doc);
		
		return docs;
	}

}
