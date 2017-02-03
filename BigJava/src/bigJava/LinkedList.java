package bigJava;

import java.util.ListIterator;
import java.util.NoSuchElementException;


public class LinkedList {
	
	private Node first;
	
	public LinkedList() {
		first = null;
	}
	
	public Object getFirst() {
		if(first == null) {throw new NoSuchElementException();}
		
		return first.data;
	}
	
	public Object removeFirst() {
		if(first == null) {throw new NoSuchElementException();}
		
		Object element = first.data;
		first = first.next;
		
		return element;
	}
	
	public void addFirst(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}
	
	public ListIterator listIterator() {
		return new LinkedListIterator();
	}
	
	class Node {
		public Object data;
		public Node next;
	}
	
	class LinkedListIterator implements ListIterator<Object> {
		
		private Node position;
		private Node previous;
		private boolean isAfterNext;
		
		public LinkedListIterator() {
			this.position = null;
			this.previous = null;
			this.isAfterNext = false;
		}

		@Override
		public void add(Object element) {
			if(this.position == null) {
				addFirst(element);
				this.position = first;
			}
			else {
				Node newNode = new Node();
				newNode.data = element;
				newNode.next =this.position.next;
				this.position.next = newNode;
			}
			
			this.isAfterNext = false;
			
		}

		@Override
		public boolean hasNext() {
			if(this.position == null) {return first != null;}
			else {return this.position != null;}
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			if(!hasNext()) {throw new NoSuchElementException();}
			this.previous = this.position;
			this.isAfterNext = true;
			
			if(this.position == null) {this.position = first;}
			else {this.position = this.position.next;}
			
			return this.position.data;
		}

		@Override
		public int nextIndex()  {
			throw new RuntimeException("remove() is not implemented");
		}

		@Override
		public Object previous() {
			throw new RuntimeException("remove() is not implemented");
		}

		@Override
		public int previousIndex() {
			throw new RuntimeException("remove() is not implemented");
		}

		@Override
		public void remove() {
			if(!this.isAfterNext) {throw new IllegalStateException();}
			if(this.position == first) {removeFirst();}
			else {this.previous.next = this.position.next;}
			this.position = this.previous;
			this.isAfterNext = false;
		}
		

		@Override
		public void set(Object element) {
			if(!this.isAfterNext) {throw new IllegalStateException();}
			this.position.data = element;	
		}
	}
}
