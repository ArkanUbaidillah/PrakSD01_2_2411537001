package Pekan6;

public class InsertDLL {
	static NodeDLL insertBegin(NodeDLL head,int data) {
		NodeDLL new_node = new NodeDLL(data);
		new_node.next= head;
		if (head!=null) {
			head.prev=new_node;
		}
		return new_node;
	}
	public static NodeDLL insertEnd(NodeDLL head,int newData) {
		NodeDLL newNode = new NodeDLL(newData);
		if (head == null) {
			head = newNode;
		}
		else {
			NodeDLL curr = head ;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next=newNode;
			newNode.prev=curr;
		}
		return head;
	}
	//fungsi menambahkan node di posisi tertentu
	public static NodeDLL insertAtPosition(NodeDLL head, int pos, int new_data) {
	    // buat node baru
	    NodeDLL new_node = new NodeDLL(new_data);

	    if (pos == 1) {
	        new_node.next = head;
	        if (head != null) {
	            head.prev = new_node;
	        }
	        head = new_node;
	        return head;
	    }

	    NodeDLL curr = head;
	    for (int i = 1; i < pos - 1 && curr != null; ++i) {
	        curr = curr.next;
	    }

	    if (curr == null) {
	        System.out.println("Posisi tidak ada");
	        return head;
	    }

	    new_node.prev = curr;
	    new_node.next = curr.next;
	    curr.next = new_node;

	    if (new_node.next != null) {
	        new_node.next.prev = new_node;
	    }

	    return head;
	}

	public static void printList(NodeDLL head) {
	    NodeDLL curr = head;
	    while (curr != null) {
	        System.out.print(curr.data + " <-> ");
	        curr = curr.next;
	    }
	    System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Arkan Ubaidillah Warman");
		System.out.println("2411537001");
		NodeDLL head = new NodeDLL(2);
	    head.next = new NodeDLL(3);
	    head.next.prev = head;
	    head.next.next = new NodeDLL(5);
	    head.next.next.prev = head.next;

	    // cetak DLL awal
	    System.out.print("DLL Awal: ");
	    printList(head);

	    // tambah 1 di awal
	    head = insertBegin(head, 1);
	    System.out.print("Simpul 1 ditambah di awal: ");
	    printList(head);

	    // tambah 6 di akhir
	    int data = 6;
	    head = insertEnd(head, data);
	    System.out.print("Simpul 6 ditambah di akhir: ");
	    printList(head);

	    // menambah node 4 di posisi 4
	    System.out.print("Tambah node 4 di posisi 4: ");
	    int data2 = 4;
	    int pos = 4;
	    head = insertAtPosition(head, pos, data2);
	    printList(head);
	}

}


