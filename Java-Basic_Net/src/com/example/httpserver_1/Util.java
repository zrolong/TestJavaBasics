package com.example.httpserver_1;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Util {
	
	
	public static void close(Closeable ... clo){
		
		for(Closeable temp : clo){
			if(temp != null){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void closeSocket(Socket socket) {

		try{
			if(socket != null){
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void closeServerSocket(ServerSocket socket) {
		
		try{
			if(socket != null){
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
