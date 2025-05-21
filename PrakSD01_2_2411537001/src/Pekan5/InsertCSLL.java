package Pekan5;


public class InsertCSLL {
	public static NodeSLL insertAtBeginning(NodeSLL last, int value) {
		NodeSLL newNode = new NodeSLL(value);
		if (last == null) {
			newNode.next = newNode;
			return newNode;
		}
		newNode.next = last.next;
		last.next = newNode;
		return last;
	}
	static NodeSLL insertEnd(NodeSLL tail, int value) {
		NodeSLL newNode = new NodeSLL(value);
		if (tail == null) {
			tail = newNode;
			newNode.next = newNode;
			
		}else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		}
		return tail;
	}
	
	static NodeSLL insertAtPosition(NodeSLL last, int data, int pos) {
		if (last == null) {
			if (pos != 1) {
				System.out.println("Posisi Salah!");
				return last;
			}
			NodeSLL newNode = new NodeSLL(data);
			last = newNode;
			last.next = last;
			return last;
		}
		NodeSLL newNode = new NodeSLL(data);
		NodeSLL curr = last.next;
		if (pos == 1) {
			newNode.next = curr;
			last.next = newNode;
			return last;
		}
		
		for (int i = 1; i<pos - 1; ++i) {
			curr = curr.next;
			if(curr == last.next) {
				System.out.println("Posisi tidak valid!");
				return last;
			}
		}
		newNode.next = curr.next;
		curr.next = newNode;
		if (curr == last) 
			last = newNode;
		return last;
		
	}
	public static void printList(NodeSLL last) {
		if (last == null)
			return;
		NodeSLL head = last.next;
		while (true) {
			System.out.print(head.data + " <--> ");
			head = head.next;
			if (head == last.next) break;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		NodeSLL first = new NodeSLL(2);
		first.next = new NodeSLL(3);
		first.next.next = new NodeSLL(4);
		NodeSLL last = first.next.next;
		last.next = first;
		System.out.print("List Awal: ");
		printList(last);
		last = insertAtBeginning(last, 1);
		System.out.print("List update (Node 1): ");
		printList(last);
		last = insertEnd(last, 6);
		System.out.print("List update (Node 6): ");
		printList(last);
		int data = 5, pos = 5;
		last = insertAtPosition(last, data, pos);
		System.out.print("List update( Node 5): ");
		printList(last);
		
		
	}

}


