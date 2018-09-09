package com.darwin.common.nlp;

import java.util.ArrayList;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

public class Segmentor {
	public static void main(String[] args) {
		System.out.println(ToAnalysis.parse("我爱北京天安门"));
		List<Term> terms = ToAnalysis.parse("我爱北京天安门").getTerms();
		System.out.println(terms);
	}
	
	public static List<String> Seg2Strings(String content){
		List<String> result = new ArrayList<String>();
		List<Term> segs = ToAnalysis.parse(content).getTerms();
		for(Term seg : segs){
			result.add(seg.getName());
		}
		return result;
	}
}
