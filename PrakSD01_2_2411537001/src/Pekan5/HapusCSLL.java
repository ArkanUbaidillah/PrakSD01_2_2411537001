package Pekan5;

public class HapusCSLL {
	public static NodeSLL deleteFirstNode(NodeSLL last) {
		if (last == null) {
			System.out.println("List is empty");
			return null;
		}
		NodeSLL head = last.next;
		if (head == last) {
			last = null;
		}else {
			last.next = head.next;
		}
		return last;
	}
	public static NodeSLL deleteSpecificNode(NodeSLL last, int key) {
		if (last == null) {
			System.out.println("List kosong. ");
			return null;
		}
		NodeSLL curr = last.next;
		NodeSLL prev = last;
		if (curr == last && curr.data == key) {
			last = null;
			return last;
		}
		if (curr.data == key) {
			last.next = curr.next;
			return last;
		}
		while (curr != last && curr.data != key) {
			prev = curr;
			curr = curr.next;
			
		}
		if(curr.data == key) {
			prev.next = curr.next;
			if(curr == last) {
				last = prev;
			}
		}else {
			System.out.println("Node " + key + " tidak ketemu");
		}
		return last;
	}
	public static NodeSLL deleteLastNode(NodeSLL last) {
		if (last == null) {
			System.out.println("List kosong");
			return null;
		}
		NodeSLL head = last.next;
		if (head == last) {
			last = null;
			return last;
		}
		NodeSLL curr = head;
		while(curr.next != last) {
			curr = curr.next;
		}
		curr.next = head;
		last = curr;
		return last;
	}
	public static void printList(NodeSLL last) {
		if (last == null) return;
		NodeSLL head = last.next;
		while(true) {
			System.out.print(head.data + " ");
			head = head.next;
			if (head == last.next) break;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		NodeSLL first = new NodeSLL(1);
		first.next = new NodeSLL(2);
		first.next.next = new NodeSLL(3);
		first.next.next.next = new NodeSLL(4);
		first.next.next.next.next = new NodeSLL(5);
		first.next.next.next.next.next = new NodeSLL(6);
		NodeSLL last = first.next.next.next.next.next;
		last.next = first;
		System.out.print("List awal: ");
		printList(last);
		last = deleteFirstNode(last);
		System.out.print("List update(first node): ");
		printList(last);
		int key = 5;
		last = deleteSpecificNode(last, key);
		System.out.print("List update(node) " + key + "): ");
		printList(last);
		last = deleteLastNode(last);
		System.out.print("List update(Node akhir): ");
		printList(last);
		
	}

}