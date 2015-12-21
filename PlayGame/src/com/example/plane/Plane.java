package com.example.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.example.util.ResourceUtil;

public class Plane {

	protected Image plane = ResourceUtil.getImage("");
	protected double x;
	protected double y;
	protected double speed;
	protected boolean left, up, right, down;

	public Plane() {

	}

	public Plane(String planePath, double x, double y) {
		this.plane = ResourceUtil.getImage(planePath);
		this.x = x;
		this.y = y;
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
			
			move();
		}
	}

	public void move() {
		if(left){
			x -= speed;
		}
		if(right){
			x += speed;
		}
		if(up){
			y -= speed;
		}
		if(down){
			y += speed;
		}
	}

}
