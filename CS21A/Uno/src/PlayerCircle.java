
public class PlayerCircle {
	private Player head = null;
	private Player tail = null;
	private int size = 0;
	 
	public void addToCircle(Player p) {
		Player temp = head;
		
		System.out.println("Adding "+p.getName()+" to the list");
		
		//If the size is zero
		if (size == 0) {
			head = p;
			tail = head;
			System.out.println("size: 0");
		}
		//If size is one
		else if(size==1){
			Player single= head;
				
			single.setNextPlayer(p);
			p.setPrevPlayer(single);
			
			single.setPrevPlayer(p);
			p.setNextPlayer(single);
			
			if(p.getName().compareTo(tail.getName())>=0){
				head=single;
				tail=p;
				System.out.println("size:1 and inserting at end");
			}else{
				head=p;
				tail=single;
				System.out.println("size:1 and inserting at head");
			}
			
		}
		//If we are inserting at the end
		else if(p.getName().compareTo(head.getName())<=0){
			
			p.setNextPlayer(head);
			head.setPrevPlayer(p);
			
			p.setPrevPlayer(tail);
			tail.setNextPlayer(p);
			
			head=p;
			System.out.println("inserting to beginning of list");
		}
		//If we are inserting at the beginning
		else if(p.getName().compareTo(tail.getName())>=0){
			p.setNextPlayer(head);
			head.setPrevPlayer(p);
			
			p.setPrevPlayer(tail);
			tail.setNextPlayer(p);
			
			tail=p;
			System.out.println("inserting to end of list");
		}
		//For every other case
		else {
			System.out.println("inserting anywhere else");

			temp = head;
			for(int i=0; i<size; i++){
				if(p.getName().compareTo(temp.getName())<=0){
					
					Player single= temp.getPrevPlayer();
					
					p.setNextPlayer(temp);
					p.setPrevPlayer(single);
					
					single.setNextPlayer(p);
					temp.setPrevPlayer(p);
					
					size++;
					this.print();
					return;
				}
				temp = temp.getNextPlayer();
			}
		}
		size++;
		this.print();
	}
	
	public Player getFirstPlayer() {
		return head;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() { 
		String s = "";
		Player temp = head;
		while (temp != null) {
			s = temp+"";
			temp = temp.getNextPlayer();
		}
		return s;
	}
	
	public void print(){
		Player temp = head;
		for(int i=0;i<size;i++){
			System.out.print(temp.getName()+ " | ");
			temp = temp.getNextPlayer();
		}
		
		System.out.println();
	}

}
