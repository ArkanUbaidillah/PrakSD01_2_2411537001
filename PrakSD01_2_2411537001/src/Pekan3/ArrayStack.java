package Pekan3;

public class ArrayStack<E> implements Stack2<E>
{
	public static final int CAPACITY = 1000;
	private E [] data;
	private int t = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	@SuppressWarnings("unchecked")

	public ArrayStack(int CAPACITY) { 
		data= (E[]) new Object[CAPACITY];
	}
	
	public int size() {
		return (t + 1);
	}
	public boolean isEmpty() {
		return (t == -1);
	}
	public void push (E e) throws IllegalStateException {
		if (size() == data.length)
			throw new IllegalStateException("Stack is full");
		data [++t]=e;
	}
	public E top() {
		if (isEmpty())
		return null;
		return data[t];
	}
	public E pop() {
		if (isEmpty())
			return null;
		E answer = data[t];
		data[t]=null;
		t--;
		return answer;
	}
	
}
