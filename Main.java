public class Main {

	public static void main(String[] args) {
		DoubleLinkedList l = new DoubleLinkedList();
		l.insert(4);
		l.insert(15);
		l.insert(2);
		
		l.print();
		
		l.delete(2); 
		
		
		l.print();
		
		l.insert(15,2);
		l.insert(35,4);
		l.print();
	}
}