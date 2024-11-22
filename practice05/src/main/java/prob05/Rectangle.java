package prob05;

public class Rectangle extends Shape implements Resizable {
	
	public Rectangle(int w, int h) {
		setWidth(w);
		setHeight(h);
	}


	@Override
	public void resize(double rate) {
		setWidth(getWidth() * 0.5); 
		setHeight(getHeight() * 0.5);
	}

	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public double getPerimeter() {
		return (getWidth() + getHeight()) * 2;
	}

}
