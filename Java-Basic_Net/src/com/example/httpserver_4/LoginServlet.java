package com.example.httpserver_4;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request request, Respond respond) throws Exception {
		
		String name = request.getParameter("name");
		String pwd  = request.getParameter("pwd"); 
		
		if(login(name,pwd)){
			respond.print("");
		}else{
			respond.print("û������û�");
		}
	}

	@Override
	public void doPost(Request request, Respond respond) throws Exception {
		
	}
	
	
	public boolean login(String name,String pwd){
		return name.equals("123") && pwd.equals("123");
	}

}