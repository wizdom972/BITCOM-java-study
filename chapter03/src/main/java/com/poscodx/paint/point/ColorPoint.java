package com.poscodx.paint.point;

public class ColorPoint extends Point {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println("Point[x=" + getX() + ", y=" + getY() + "color=" + color + "]를 그렸습니다.");
	}
}
