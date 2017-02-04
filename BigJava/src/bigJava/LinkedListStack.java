package bigJava;

import java.util.NoSuchElementException;

public class LinkedListStack {
	
	private Node first;
	
	public LinkedListStack() {
		this.first = null;
	}
	
	public void push(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = this.first;
		this.first = newNode;
	}
	
	public Object pop() {
		if(this.first == null) {throw new NoSuchElementException();}
		Object element = this.first.data;
		this.first = this.first.next;
		return element;
	}
	
	public boolean empty() {
		return this.first == null;
	}
	
	
	class Node {
		public Object data;
		public Node next;
	}

}
