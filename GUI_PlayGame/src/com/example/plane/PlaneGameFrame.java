package com.example.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.constant.Constant;
import com.example.util.MyFrame;
import com.example.util.ResourceUtil;

public class PlaneGameFrame extends MyFrame {

	private static final long serialVersionUID = 391225611844072051L;
	private int maxBullet = 50;
	private Image bground = ResourceUtil.getImage("");
	private Plane plane = new Plane("", 200, 200);
	private List<Bullet> list = new ArrayList<Bullet>();
	
	private Date startTime;
	private Date endTime;

	@Override
	public void launchFrame() {

		// parent function
		super.launchFrame();

		for (int i = 0; i <= maxBullet; i++) {
			Bullet bullet = new Bullet();
			this.list.add(bullet);
		}
		// add key listecer
		addKeyListener(new KeyMonitor());
		this.startTime = new Date();
	}
	private int count = 0;
	private Explode ex = null;
	
	public void paint(Graphics g) {

		if (bground != null) {
			g.drawImage(bground, 0, 0, null);
		} else {
			setBackground(Color.white);
		}
		if( plane.isLive()){
			count ++;
			privtInfo(g, "分数：" + count, 12, 50, 50);
			plane.draw(g);
		}
		for (Bullet b : list) {
			b.draw(g);
			boolean boo = b.getRect().intersects(plane.getRect());
			if(boo){
				this.endTime = new Date();
				if(ex == null){
					plane.setLive(false);
					ex = new Explode(plane.x, plane.y);
					ex.draw(g);
				}else{
					ex.draw(g);
				}
			}
		}
		
		if(!plane.isLive()){
			plane.width = 0;
			plane.height = 0;
			privtInfo(g, "分数：" + count, 12, 50, 50);
			privtInfo(g,"GAME OVER",16,Constant.GAME_WIDTH / 2 - 44, Constant.GAME_HEIGHT / 2);
			long period = (endTime.getTime() - startTime.getTime()) / 1000;
			privtInfo(g,"Time:" + period + "s",16,Constant.GAME_WIDTH / 2 - 44, Constant.GAME_HEIGHT / 2 + 20);
		}
	}
	
	private void privtInfo(Graphics g,String info,int size,int x,int y){
		Font f = new Font("宋体", Font.BOLD, size);
		g.setFont(f);
		g.drawString(info,x,y);
	}
	
	/**
	 * 使用内部类可以方便的使用外部类的方法
	 * 
	 * @author 北飞的候鸟
	 *
	 */
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {

			plane.removeDirection(e);
		}

	}

	public static void main(String[] args) {
		PlaneGameFrame frame = new PlaneGameFrame();
		frame.launchFrame();
	}
}
