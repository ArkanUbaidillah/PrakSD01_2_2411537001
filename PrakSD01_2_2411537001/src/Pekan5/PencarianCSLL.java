package Pekan5;

public class PencarianCSLL {
	static boolean search(NodeSLL last, int key) {
		if (last == null) {
			return false;
		}
		NodeSLL head = last.next;
		NodeSLL curr = head;
		while (curr != last) {
			if(curr.data == key) {
				return true;
			}
			curr = curr.next;
		}
		if(last.data == key) {
			return true;
		}
		return false;
	}
	static void printList(NodeSLL last) {
		if(last == null) return;
		NodeSLL head = last.next;
		while (true) {
			System.out.print(head.data + " ");
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
		System.out.print("list asli: ");
		printList(last);
		int key = 4;
		boolean found = search(last, key);
		if (found) {
			System.out.println("Nilai " + key + " ditemukan.");
		}else {
			System.out.println("Nilai " + key + " Tidak ditemukan");
		}
		

	}

}