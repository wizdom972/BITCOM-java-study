package com.poscodx.paint.shape;

import com.poscodx.paint.point.Point;

public abstract class Shape {
	private Point[] points;
	private String lineColor;
	private String fillColor;
	
	abstract public void draw();
}
