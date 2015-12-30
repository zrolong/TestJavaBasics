package com.example.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * 1���ָ��ļ�
 * 
 * @author ���ɵĺ���
 *
 */

@SuppressWarnings("unused")
public class SplitFile {
	
	//�ļ���·��
	private String filePath;
	//File Size
	private int size;
	//Split File Size
	private long blockSize;
	//
	private List<String> blockPath;
	
	private String fileName;
	
	private long fileLength;
	
	
	public SplitFile() {
		
		this.blockPath = new ArrayList<String>();
	}


	public SplitFile(String filePath) {
	
		this(filePath,1024);
		this.blockSize = 1024;
		this.filePath = filePath;
	}
	
	
	public SplitFile(String filePath,long blockSize) {

		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
	}
	
	
	
	public SplitFile(String filePath, int size, Long blockSize,
			List<String> blockPath) {

		this.filePath = filePath;
		this.size = size;
		this.blockSize = blockSize;
		this.blockPath = blockPath;
	}
	
	public void init(){
		
		File src = null;
		if(filePath == null || !(src = new File(filePath)).exists()){
			return;
		}
		if(src.isDirectory()){
			return;
		}
		
		this.fileName = src.getName();
		this.fileLength = src.length();
		//������С��ʵ�ʴ�С��ľ���С
		long length = src.length();
		if(this.blockSize > length ){
			this.blockSize = length;
		}
		size = (int)(Math.ceil(length * 1.0 / this.blockSize));
	}
	
	private void initPathName(String destPath){
		
		for(int i = 0; i < size; i++){
			this.blockPath.add(destPath + "/"+ this.fileName +".path" + i);
		}
		
	}
	
	/**
	 * �ļ��ķָ�
	 * �ļ�����ʵλ��
	 * ʵ�ʴ�С
	 * @param destPath
	 */
	public void split(String destPath){
		
		//
		initPathName(destPath);
		long beginPos = 0;
		long actualBlockSize = blockSize;
		for (int i = 0; i < size; i++) {
			if(i == size - 1){
				actualBlockSize = this.fileLength - beginPos;
			}
			spiltDetail(i,beginPos,actualBlockSize);
		}
	}
	
	/**
	 * �ļ�����
	 * @param idx
	 * @param beginPos
	 * @param actualBlockSize
	 */
	private void spiltDetail(int idx,long beginPos,long actualBlockSize){
		
		File src  = new File(this.filePath);
		File dest = new File(this.blockPath.get(idx)); 
	
		RandomAccessFile raf = null;
		BufferedOutputStream bos = null;
		try {
			 raf = new RandomAccessFile(src,"r");
			 bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			 //��ȡ�ļ�
			 raf.seek(beginPos);
			 //TODO
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}