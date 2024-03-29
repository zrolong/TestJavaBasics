package com.example.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.example.util.ResourceUtil;

public class Plane extends GameObject{

	protected Image plane = ResourceUtil.getImage("");
	protected boolean left = false;
	protected boolean up = false;
	protected boolean right = false;
	protected boolean  down =false;
	
	private boolean live = true;

	public Plane() {

	}

	public Plane(String planePath, double x, double y) {
		this.plane = ResourceUtil.getImage(planePath);
		if(plane != null){
			width = plane.getWidth(null);
			height = plane.getHeight(null);
		}else{
			width = 15;
			height = 15;
		}
		this.x = x;
		this.y = y;
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {

		if (plane != null) {
			g.drawImage(plane, 0, 0, null);
		} else {
			Color c = g.getColor();
			g.setColor(Color.green);
			g.fillOval((int) x, (int) y, 15, 15);
			g.setColor(c);
			g.drawString("You", (int) (x - 2), (int) (y + 25));

			this.move();
		}
	}

	public void move() {
		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
	}

	public void addDirection(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}

	public void removeDirection(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}

}
