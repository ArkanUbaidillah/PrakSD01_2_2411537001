package Pekan5;

public class PencarianSLL {
	static boolean searchKey(NodeSLL head,int key) {
		NodeSLL curr=head;
		while (curr != null) {
			if (curr.data == key)
				return true;
			curr = curr.next;
		} return false;
	}
	public static void traversal(NodeSLL head) {
		NodeSLL curr = head;
		while (curr !=null ) {
			System.out.print(" " + curr.data);
			curr=curr.next;
		}System.out.println();
	}

	public static void main(String[] args) {
		NodeSLL head = new NodeSLL (14);
		head.next=new NodeSLL (21);
		head.next.next=new NodeSLL (13);
		head.next.next.next=new NodeSLL (30);
		head.next.next.next.next=new NodeSLL (10);
		System.out.print("Penelusuran SLL : ");
		traversal (head);
		int key = 30;
		System.out.print("cari data "+key+ "=");
		if (searchKey(head,key))
			System.out.println("Ketemu");
		else
			System.out.println("Tidak ada");

	}

}
