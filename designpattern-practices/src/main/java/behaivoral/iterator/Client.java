package behaivoral.iterator;

public class Client {

	public static void main(String[] args) {
		Aggregate<String> fruits = new AggregateImpl<String>(new String[] {"mango", "banana", "apple"});
		
		Iterator<String> it = fruits.createIterator();
		while (it.hasNext()) {
			String fruit = it.next();
			System.out.println(fruit);
		}
	}

}
