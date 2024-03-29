package com.example.httpserver_3;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
	
	//為每個servlet去一个别名
	private Map<String,String> servlet;
	
	//url---->login
	private Map<String,String> mapping;
	

	public ServletContext() {
	
		servlet = new HashMap<String,String>();
		mapping = new HashMap<String,String>();
	}

	public ServletContext( Map<String, String> mapping , Map<String, String> servlet) {
		this.servlet = servlet;
		this.mapping = mapping;
	}

	public Map<String, String> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
}
