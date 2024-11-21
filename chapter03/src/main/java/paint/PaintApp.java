package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point = new Point();
		
		point.setX(10);
		point.setY(20);
		
		point.show();
		
		Point point2 = new Point();
		
		point2.setX(12);
		point2.setY(13);
		
		point2.show(false);
	}

}
