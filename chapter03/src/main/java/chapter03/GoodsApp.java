package chapter03;

public class GoodsApp {
	public static void main(String[] args) {
		Goods goods = new Goods();
		
//		camera.name = "nikon";
//		camera.price = 400000;
//		camera.countStock = 30;
//		camera.countSold = 50;
//		
//		System.out.println("상품이름: " + camera.name);
//		System.out.println("가격: " + camera.price);
//		System.out.println("재고개수: " + camera.countStock);
//		System.out.println("팔린 개수: " + camera.countSold);
		
		goods.setName("nikon");
		goods.setPrice(400000);
		goods.setCountStock(10);
		goods.setCountSold(30);
		
//		System.out.println("상품이름: " + camera.getName());
//		System.out.println("가격: " + camera.getPrice());
//		System.out.println("재고개수: " + camera.getCountStock());
//		System.out.println("팔린 개수: " + camera.getCountSold());
		
		goods.printInfo();
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(goods.clacDiscountPrice(0.3f));
	}
}
