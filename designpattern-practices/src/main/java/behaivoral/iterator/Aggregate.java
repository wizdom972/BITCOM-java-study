package behaivoral.iterator;

public interface Aggregate<E> {
	Iterator<E> createIterator();
}
