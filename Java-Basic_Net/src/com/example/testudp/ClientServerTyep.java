package com.example.testudp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ClientServerTyep {

public static void main(String[] args) {
		
		try {
			//创建服务器 + 端口
			DatagramSocket ds = new DatagramSocket(1993);
			//准备接受容器
			byte[] containet = new byte[1024];
			//封装成包daraGrampacket
			DatagramPacket packet = new DatagramPacket(containet,containet.length);
			//接受数据
			ds.receive(packet);
			//解析数据
			byte[] data = packet.getData();
			//int len = packet.getLength();
			//System.out.println(new String(data,0,len));
			System.out.println(convert(data));
			
			ds.close();
			
			
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public static double convert(byte[] data){
	
	DataInputStream dis  = new DataInputStream(new ByteArrayInputStream(data));
	double num = 0;
		try {
			num = dis.readDouble();
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	
	}
}
