package Pekan5;

public class TambahSLL {

    // Method untuk mencetak linked list
    public static void printList(NodeSLL head) {
        NodeSLL curr = head;
        while (curr != null) {
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Method untuk menambahkan simpul di awal
    public static NodeSLL insertAtFront(NodeSLL head, int value) {
        NodeSLL new_node = new NodeSLL(value);
        new_node.next = head;
        return new_node;
    }

    // Method untuk menambahkan simpul di akhir
    public static NodeSLL insertAtEnd(NodeSLL head, int value) {
        NodeSLL newNode = new NodeSLL(value);
        if (head == null) {
            return newNode;
        }
        NodeSLL last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return head;
    }

    // Method untuk menambahkan simpul di posisi tertentu
    public static NodeSLL insertPos(NodeSLL head, int position, int value) {
        if (position < 1) {
            System.out.println("Invalid position");
            return head;
        }
        if (position == 1) {
            NodeSLL new_node = new NodeSLL(value);
            new_node.next = head;
            return new_node;
        }
        NodeSLL current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of range");
            return head;
        }
        NodeSLL newNode = new NodeSLL(value);
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    // Main method
    public static void main(String[] args) {
        NodeSLL head = new NodeSLL(2);
        head.next = new NodeSLL(3);
        head.next.next = new NodeSLL(5);
        head.next.next.next = new NodeSLL(6);

        System.out.print("Senarai berantai awal : ");
        printList(head);

        System.out.print("Tambah satu simpul di depan : ");
        int data = 1;
        head = insertAtFront(head, data);
        printList(head);

        System.out.print("Tambah satu simpul di belakang : ");
        int data2 = 7;
        head = insertAtEnd(head, data2);
        printList(head);

        System.out.print("Tambah satu simpul ke posisi 4 : ");
        int data3 = 4;
        int pos = 4;
        head = insertPos(head, pos, data3);
        printList(head);
    }
}