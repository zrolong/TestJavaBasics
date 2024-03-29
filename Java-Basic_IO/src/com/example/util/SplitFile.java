package com.example.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 1、分割文件
 * 
 * @author 北飞的候鸟
 *
 */

public class SplitFile {

	// 文件的路径
	private String filePath;
	// File Size
	int size;
	// Split File Size
	private long blockSize;
	// 文件list
	private List<String> blockPath;
	// 分割后的存放目录
	@SuppressWarnings("unused")
	private String destBlockPath;
	// 文件名字
	private String fileName;
	// 文件大小
	private long fileLength;

	public SplitFile() {

		this.blockPath = new ArrayList<String>();
	}

	public SplitFile(String filePath, String destBlockPath) {

		this(filePath, 1024, destBlockPath);
		this.blockSize = 1024;
		this.filePath = filePath;
	}

	public SplitFile(String filePath, long blockSize, String destBlockPath) {

		this();
		this.destBlockPath = destBlockPath;
		this.filePath = filePath;
		this.blockSize = blockSize;
		init();
	}

	public SplitFile(String filePath, int size, Long blockSize, List<String> blockPath) {

		this.filePath = filePath;
		this.size = size;
		this.blockSize = blockSize;
		this.blockPath = blockPath;
	}

	public void init() {

		File src = null;
		if (filePath == null || !(src = new File(filePath)).exists()) {
			return;
		}
		if (src.isDirectory()) {
			return;
		}

		this.fileName = src.getName();
		this.fileLength = src.length();
		// 计算块大小，实际大小与木块大小
		long length = src.length();
		if (this.blockSize > length) {
			this.blockSize = length;
		}
		size = (int) (Math.ceil(length * 1.0 / this.blockSize));
	}

	private void initPathName(String destPath) {

		for (int i = 0; i < size; i++) {
			this.blockPath.add(destPath + "/" + this.fileName + ".path" + i + ".txt");
		}

	}

	/**
	 * 文件的分割 文件的其实位置 实际大小
	 * 
	 * @param destPath
	 */
	public void split(String destPath) {

		// 确定文件的路径
		initPathName(destPath);

		long beginPos = 0;
		long actualBlockSize = blockSize;
		// 计算所有块的大小，位置，和索引
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				actualBlockSize = this.fileLength - beginPos;
			}
			spiltDetail(i, beginPos, actualBlockSize);
		}
	}

	/**
	 * 文件拷贝
	 * 
	 * @param idx
	 * @param beginPos
	 * @param actualBlockSize
	 */
	private void spiltDetail(int idx, long beginPos, long actualBlockSize) {

		File src = new File(this.filePath);
		File dest = new File(this.blockPath.get(idx));

		RandomAccessFile raf = null;
		BufferedOutputStream bos = null;
		try {
			raf = new RandomAccessFile(src, "r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));

			// 读取文件
			raf.seek(beginPos);
			// 缓存
			byte[] flush = new byte[1024];
			int len = 0;
			while (-1 != (len = raf.read(flush))) {

				if (actualBlockSize - len >= 0) {
					bos.write(flush, 0, len);
					actualBlockSize -= len;
				} else {
					bos.write(flush, 0, (int) actualBlockSize);
					break;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 文件的合并
	 */

	public void margeFile1(String destPath) {

		File dest = new File(destPath);

		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;

		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest, true));
			for (int i = 0; i < this.blockSize; i++) {

				bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));

				byte[] flush = new byte[1024];
				int len = 0;

				while (-1 != (len = bis.read(flush, 0, len))) {
					bos.write(flush, 0, len);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void margeFile(String destPath)  {

		File dest = new File(destPath);

		BufferedOutputStream bos = null;// 输出流
		SequenceInputStream sis = null;// 输入流

		Vector<InputStream> vi = new Vector<>();

		try {
			
			for (int i = 0; i < this.blockPath.size(); i++) {
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));

			}
			sis = new SequenceInputStream(vi.elements());
			bos = new BufferedOutputStream(new FileOutputStream(dest, true));

			byte[] flush = new byte[1024];
			int len = 0;

			while (-1 != (len = sis.read(flush, 0, len))) {
				bos.write(flush, 0, len);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sis != null) {
				try {
					sis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}