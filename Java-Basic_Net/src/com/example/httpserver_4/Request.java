package com.example.httpserver_4;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Request {

	private static final String CRLF  = "/r/n";
	@SuppressWarnings("unused")
	private static final String BLANK = "";
	
	@SuppressWarnings("unused")
	private InputStream is;
	
	private Map<String,List<String>> parameterMapValues;
	
	private String requestInfo;
	private String method;
	private String url;
	
	
	public Request() {
	
		method = "";
		url = "";
		parameterMapValues = new HashMap<>();
		requestInfo = "";
	}
	
	public Request(InputStream is){
		
		this();
		this.is = is;
		try{
			
			byte[] data = new byte[20480];
			int len = is.read(data);
			requestInfo = new String(data,0,len);
		}catch(Exception e){
			e.printStackTrace();
		}
		parseRequestInfo();
	}
	
	
	public void parseRequestInfo(){
		
		//接收请求参数
		String paramString = "";
		
		//获取请求参数
		String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx = requestInfo.indexOf("/");
		this.method = firstLine.substring(0, idx).trim();
		String urlStr = firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("post")){
			
			this.url = urlStr;
			paramString = requestInfo.substring(requestInfo.indexOf(CRLF)).trim();
		
		}else if(this.method.equalsIgnoreCase("get")){
			
			if(urlStr.contains("?")){
				
				String[] urlArray = urlStr.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1];
				
			}else{
				
				this.url = urlStr;
			}
		}
		if(paramString.equals("")){
			return;
		}
		parseParams(paramString);
	
	}
	
	private void parseParams(String paramString){
		
		StringTokenizer token = new StringTokenizer(paramString, "&");
		while(token.hasMoreTokens()){
			
			String keyValue = token.nextToken();
			String[] keyValues = keyValue.split("=");
			if(keyValues.length == 1){
				keyValues = Arrays.copyOf(keyValues,2);
				keyValues[1] = null;
				
			}
			String key   = keyValues[0].trim();
			String value = null == keyValues[1] ? null : decode(keyValues[1].trim(),"gbk");
			//转换成map
			if(this.parameterMapValues.containsKey(key)){
				parameterMapValues.put(key, new ArrayList<String>());
			}
			
			List<String> values = parameterMapValues.get(key);
			values.add(value);
		
		}
	}
	
	/**
	 * 
	 * @param value
	 * @param code
	 * @return
	 */
	
	private String decode(String value,String code){
		
		try{
			
			return java.net.URLDecoder.decode(value,code);
			
		}catch(UnsupportedEncodingException e){
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * 根据页面的请求获取多个值
	 * 
	 * @param name
	 * @return
	 */
	
	public String[] getParameterValues(String name){
		
		List<String> values = null;
		if((values = parameterMapValues.get(name)) == null){
			return null;
		}else{
			return values.toArray(new String[0]);
		}
	}
	
	/**
	 * 
	 * 根据页面的name 获取对应的值
	 * 
	 * @param name
	 * @return
	 */
	
	public String getParameter(String name){
	
		String[] values = getParameterValues(name);
		if(values == null){
			return null;  
		}
		return values[0];
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void pushToClient(int code) {
		
	}

}