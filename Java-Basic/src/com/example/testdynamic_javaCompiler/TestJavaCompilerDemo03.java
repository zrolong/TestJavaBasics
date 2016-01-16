package com.example.testdynamic_javaCompiler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ���Խű�����ִ��javaScript
 * 
 * @author ���ɵĺ���
 *
 */

@SuppressWarnings("all")
public class TestJavaCompilerDemo03 {

	public static void main(String[] args) {

		try {
			// ��ýű��������
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine engine = sem.getEngineByName("javascript");
			// ����������洢������������
			engine.put("msg", "this is a goog code");
			String str = "var user = {name : 'man', age : 18,schools : ['xikeda','nankeda'] };";
			str += "print(user.name);";

			// ִ��У��
			engine.eval(str);

			engine.eval("msg = 'sxt is a goog school' ;");

			System.out.println(engine.get("msg"));

			System.out.println("**************************************************");

			engine.eval("function add(a,b) { var sum = a + b ; return sum ; }");

			Invocable in = (Invocable) engine;
			Object result = in.invokeFunction("add", new Object[] { 13, 20 });
			System.out.println(result);

			System.out.println("**************************************************");
			// ��������java����ʹ���������е�java��
			// String jsCode = "import java.util.*; var
			// list=Arrays.asList([\"������ѧ��\",\"�廪��ѧ\",\"������ѧ\"]);";
			// engine.eval(jsCode);
			// List<String> list = (List<String>)engine.get("list");
			//
			//
			// for(String temp : list){
			// System.out.println(temp);
			// }
			System.out.println("**************************************************");

			//URL url = TestJavaCompilerDemo03.class.getClassLoader().getResource("a.js");
			//FileReader fr = new FileReader(url.getPath());
			///Jav-Basics/src/com/example/testdynamic_javaCompiler/a.js
			FileReader fr = new FileReader("src/com/example/testdynamic_javaCompiler/a.js");
			engine.eval(fr);
			fr.close();

		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}