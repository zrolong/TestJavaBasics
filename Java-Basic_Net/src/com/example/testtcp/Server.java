package com.example.testtcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����
 * 
 * @author ���ɵĺ���
 *
 */
public class Server {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//�����ͻ���
			ServerSocket serverSocket = new ServerSocket(1993);
			//���ܿͻ��˵����ӣ�����ʽ
			Socket socket =  serverSocket.accept();
			serverSocket.close();
			
			OutputStream os = socket.getOutputStream();
			String msg = "��ӭʹ��";
			
			/*
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(os));
			bw.write(msg);
			bw.newLine();
			bw.flush();
			*/
			
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(msg);
			dos.flush();
			dos.close();
			
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}