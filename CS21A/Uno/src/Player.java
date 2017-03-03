
public class Player {
	private String name;
	private Player nextPlayer=null;
	private Player prevPlayer=null;
	private SinglyLinkedList<UnoCard> hand; 
	
	public Player(String name) {
		this.name = name;
		hand = new SinglyLinkedList<UnoCard>();
	}
	
	public void addToHand(UnoCard c) {
		//you have to implement this
		hand.regularInsert(c);
	}
	
	public UnoCard removeFromHand(int index) {
		//you have to implement this
		//returns the UnoCard that was removed
		return hand.removeIndex(index);
	}
	
	public boolean winner(){
		// return true when your hand has nothing left. 
		// you have to implement this
		if (hand.size() == 0) {
			return true;
		}
		return false;
	}

	public Player getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	public Player getPrevPlayer() {
		return prevPlayer;
	}

	public void setPrevPlayer(Player prevPlayer) {
		this.prevPlayer = prevPlayer;
	}
	 
	public String getName() {
		return name;
	}

	public String toString() {
		return "Player "+name;
	}
	
	
}
