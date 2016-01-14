package com.example.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 
 * @author ���ɵĺ���
 *
 */
public class ResourceUtil {
	
	/**
	 * 
	 * Util�����ѹ��췽��˽��
	 *
	 */
	private ResourceUtil(){
		
	}
	
	public static Image getImage(String path){
		
		URL url = ResourceUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
			return img;
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("û�л�ȡ��ͼƬ");
			return null;
		}finally{
			url = null;
		}
		
	}

}