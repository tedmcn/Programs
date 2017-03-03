public class SinglyLinkedNode<T> {
	private SinglyLinkedNode<T> next;
	private T data;
	
	public SinglyLinkedNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setNext(SinglyLinkedNode<T> nextNode) {
		next = nextNode; 
		getNext();
	}
	
	public SinglyLinkedNode<T> getNext() {
		return next;
	}
	
	public String toString() {
		return ""+data;
	}

}
