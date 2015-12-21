package com.example.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.example.util.MyFrame;
import com.example.util.ResourceUtil;

public class PlaneGameFrame extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 391225611844072051L;

	private Image bground = ResourceUtil.getImage("");
	private Plane plane = new Plane("", 200, 200);

	public void paint(Graphics g) {

		if (bground != null) {
			g.drawImage(bground, 0, 0, null);
		} else {
			setBackground(Color.white);
		}
		plane.draw(g);

	}

	@Override
	public void launchFrame() {

		// parent function
		super.launchFrame();
		// add key listecer
		addKeyListener(new KeyMonitor());
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

			switch (e.getKeyCode()) {
			case 37:

				break;
			case 38:

				break;
			case 39:

				break;
			case 40:

				break;

			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

	public static void main(String[] args) {
		PlaneGameFrame frame = new PlaneGameFrame();
		frame.launchFrame();
	}
}
