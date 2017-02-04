package bigJava;

import java.util.NoSuchElementException;

public class CircularArrayQueue {
	
	private Object[] buffer;
	private int currentSize;
	private int head;
	private int tail;
	
	
	public CircularArrayQueue() {
		final int INITIAL_SIZE = 10;
		buffer = new Object[INITIAL_SIZE];
		this.currentSize = 0;
		this.head = 0;
		this.tail = 0;
	}
	
	public boolean empty() {return this.currentSize == 0;}
	
	public void add(Object newElement) {
		growBufferIfNecessary();
		this.currentSize++;
		this.buffer[this.tail] = newElement;
		this.tail = (tail + 1)%this.buffer.length;
	}
	
	public Object remove() {
		if(this.currentSize == 0) {throw new NoSuchElementException();}
		Object remove = this.buffer[this.head];
		this.head = (this.head + 1) % this.buffer.length;
		this.currentSize--;
		return remove;
	}
	
	
	private void growBufferIfNecessary() {
		if(this.currentSize == this.buffer.length) {
			Object[] newBuffer = new Object[2 * this.buffer.length];
			for(int i = 0; i < this.buffer.length; i++) {
				newBuffer[i] = this.buffer[(head + i) % this.buffer.length];
			}
			this.buffer = newBuffer;
			this.head = 0;
			this.tail = this.currentSize;
		}
	}
	

}
