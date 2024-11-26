package behaivoral.iterator;

public class AggregateImpl<E> implements Aggregate<E> {
	private E[] datas = null;
	
	public AggregateImpl(E[] datas) {
		this.datas = datas;
	}

	@Override
	public Iterator<E> createIterator() {
		// TODO Auto-generated method stub
		return new IteratorImpl();
	}
	
	private class IteratorImpl implements Iterator<E> {
		private int index = 0;

		@Override
		public E next() {
			return index < datas.length ? datas[index++] : null;
		}

		@Override
		public boolean hasNext() {
			return index < datas.length;
		}
		
	}
	
}
