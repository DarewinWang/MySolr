package com.darwin.common.nlp;

import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import com.hankcs.hanlp.HanLP;

public class Segmentor {
	public static void main(String[] args) {
		System.out.println(ToAnalysis.parse("我爱北京天安门"));
		List<Term> terms = ToAnalysis.parse("我爱北京天安门").getTerms();
		System.out.println(terms);
		System.out.println(HanLP.segment("我爱北京天安门"));
		String document = "Portable版的基本功能指的是，除CRF分词、依存句法分析外的全部功能。如果用户有自定义的需求， 可以使用hanlp.properties进行配置。"
				+ "Portable版依然可以从hanlp.properties中获取配置信息， 这使得用户可以挂载自定义词典、挂载CRF模型、使用外部词典覆盖内置词典等等。";
		System.out.println(HanLP.extractKeyword(document, 5));
	}
}
