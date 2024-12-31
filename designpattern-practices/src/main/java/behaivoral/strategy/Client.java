package behaivoral.strategy;

public class Client {

	public static void main(String[] args) {
		CalculateContext cc = new CalculateContext();
		
		cc.operation(new CalculateStrategy() {
			
			@Override
			public int calculate(int val1, int val2) {
				return val1 + val2;
			}
		});
		
		
		// 람다 버전
		cc.operation((val1, val2) -> {
				return val1 + val2;
			}
		);
		
		// 한줄 버전
		cc.operation((val1, val2) ->  val1 - val2);
	}

}
