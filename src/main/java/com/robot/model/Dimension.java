package com.robot.model;

/**
 * Class to represent co-ordinates and behave as dimension size.
 */
public class Dimension {
	private int x;
	private int y;

	public Dimension(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Dimension of(int x, int y) {
		return new Dimension(x, y);
	}

	public void incrementX() {
		x++;
	}

	public void decrementX() {
		x--;
	}

	public void incrementY() {
		y++;
	}

	public void decrementY() {
		y--;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
