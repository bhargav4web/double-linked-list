public class DoubleLinkedList extends LinkedList {
	Node tail;
	
	@Override
    public void insert(int d)
    {
        Node n = new Node();
        n.data = d;
        if(head == null)
        {
            head = n;
        	tail = n;
        } 
        else{
        	n.prev = tail;
        	tail.next = n;
        	tail = n;
        }
    }
	
	@Override
    public void insert(int d, int pos)
    {
        Node n = new Node();
        n.data = d;

        Node curr = this.head;

        if(pos!=1){
            for(int i=1; i<pos-1; i++)
                curr = curr.next;
            n.prev = curr;
            n.next = curr.next;
            if(curr.next!=null)
            	curr.next.prev = n;
            curr.next = n;
        }
        else{
            n.next = this.head;
            this.head = n;
        }

    }
	
}
