package prob05;

public class RectTriangle extends Shape {
	public RectTriangle(int w, int h) {
		setWidth(w);
		setHeight(h);
	}

	@Override
	public double getArea() {
		return getWidth() * getHeight() * 0.5;
	}

	@Override
	public double getPerimeter() {
		return getWidth() + getHeight() + Math.sqrt(getWidth() * getWidth() + getHeight() + getHeight());
	}

}
