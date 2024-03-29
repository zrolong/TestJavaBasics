package com.example.guava;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class GuavaDemo03 {

	/**
	 * 转换
	 * 
	 * 组合是函数变成
	 * 确保容器的大小不超过5
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("1","2","3");
		list.add("4");
		list.add("5");
		list.add("6");
		
		Function<String, String> f1 = new Function<String, String>() {

			@Override
			public String apply(String arg0) {
				return arg0.length() > 5 ? arg0.substring(0, 5) : arg0;
			}
		};
		
		Function<String, String> f2 = new Function<String, String>() {

			@Override
			public String apply(String in) {
				return in.toUpperCase();
			}
		};
		
		Function<String, String> f = Functions.compose(f1, f2);
		
		Collection<String> ls = Collections2.transform(list,f);
		
		for(String s : ls){
			System.out.println(s);
		}
	}
}
