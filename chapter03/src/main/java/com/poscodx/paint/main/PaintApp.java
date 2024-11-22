package com.poscodx.paint.main;

import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;

public class PaintApp {

	public static void main(String[] args) {
		Point point = new Point();
		
		point.setX(10);
		point.setY(20);
		
//		point.show();
		drawPoint(point);
		
		
		Point point2 = new Point();
		
		point2.setX(12);
		point2.setY(13);
		
//		point2.show(false);
		drawPoint(point2);
		
		// color point
		ColorPoint point3 = new ColorPoint();
		
		point3.setX(12);
		point3.setY(24);
		point3.setColor("red");
		
		drawPoint(point3);
		
		// instanceof 연산자
		Triangle t = new Triangle();
		
		System.out.println(t instanceof Triangle);
		
		// 연산자 우측항이 인터페이스인 경우
		// 하이라키 상관없이 연산자 사용 가능
		System.out.println(t instanceof Runnable);
		
		}
	
	public static void drawPoint(Point point) {
		point.show();
	}
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}

}
