package com.example.chat_3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{

	/**
	 * ����̨������
	 */
	private BufferedReader console;
	/**
	 * �����
	 */
	private DataOutputStream dos;
	private boolean isRunning = true;
	
	@SuppressWarnings("unused")
	private String name;
	
	
	public Send() {
		this.console = new BufferedReader(new InputStreamReader(System.in));
	}


	public Send(Socket client,String name) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
			send(name);
		} catch (IOException e) {
			e.printStackTrace();
			isRunning = false;
			Util.close(dos,console);
		}
	}
	
	private String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * �ӿ���̨����
	 */
	public void send(String msg){
		if(null != 	msg && !msg.equals("")){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				isRunning = false;
				Util.close(dos,console);
			}
		}
	}

	@Override
	public void run() {
		while(isRunning){
			send(getMsgFromConsole());
		}
	}

}