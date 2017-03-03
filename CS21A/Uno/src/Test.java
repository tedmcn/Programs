
public class Test {

	public static <T> void main(String[] args) {
		SinglyLinkedList<T> l = new SinglyLinkedList<T>();
		
		//Test single link list
		UnoCard x = new UnoCard("Blue", 3);
		UnoCard y = new UnoCard("Red", 3);
		UnoCard z = new UnoCard("Yellow", 3);
		UnoCard a = new UnoCard("Blue", 7);
		UnoCard q = new UnoCard("Green", 8);
		l.regularInsert((T)x);
		l.regularInsert((T)y);
		l.regularInsert((T)z);
		l.regularInsert((T)a);
		l.regularInsert((T)q);
		System.out.println(l.toString());
		testQueue();
		testCDLL();
	}

	public static <T> void testQueue() {
		Queue<T> q = new Queue<T>(5);
		String s1 = "Joshua";
		String s2 = "Antonella";
		String s3 = "Simon";
		String s4 = "Hunter";
		String s5 = "Shayla";
		q.enqueue((T)s1);
		q.enqueue((T)s2);
		q.enqueue((T)s3);
		q.enqueue((T)s4);
		q.enqueue((T)s5);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
	
	public static void testCDLL() {
		PlayerCircle P = new PlayerCircle();
		Player p1 = new Player("Joshua");
		Player p2 = new Player("Z");
		Player p3 = new Player("Elmer");
		Player p4 = new Player("Jacob");
		Player p5 = new Player("Lina"); 
		P.addToCircle(p1);
		P.addToCircle(p2);
		P.addToCircle(p3);
		P.addToCircle(p4); 
		P.addToCircle(p5);
	}
}
