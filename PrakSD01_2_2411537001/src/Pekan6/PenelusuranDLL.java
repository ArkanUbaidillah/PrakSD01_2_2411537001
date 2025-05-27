package Pekan6;

public class PenelusuranDLL {
    // fungsi penelusuran maju
    static void forwardTraversal(NodeDLL head) {
        // memulai penelusuran dari head
        NodeDLL curr = head;

        // lanjutkan sampai akhir
        while (curr != null) {
            // print data
            System.out.print(curr.data + " <-> ");
            // pindah ke node berikutnya
            curr = curr.next;
        }

        // print spasi
        System.out.println();
    }

    // fungsi penelusuran mundur
    static void backwardTraversal(NodeDLL tail) {
        // mulai dari akhir
        NodeDLL curr = tail;

        // lanjut sampai head
        while (curr != null) {
            // cetak data
            System.out.print(curr.data + " <-> ");
            // pindah ke node sebelumnya
            curr = curr.prev;
        }

        // cetak spasi
        System.out.println();
    }
    public static void main (String[]args) {
    	System.out.println("Arkan Ubaidillah Warman");
    	System.out.println("2411537001");
    	 NodeDLL head = new NodeDLL(1);
    	    NodeDLL second = new NodeDLL(2);
    	    NodeDLL third = new NodeDLL(3);

    	    head.next = second;
    	    second.prev = head;
    	    second.next = third;
    	    third.prev = second;

    	    System.out.println("Penelusuran maju:");
    	    forwardTraversal(head);

    	    System.out.println("Penelusuran mundur:");
    	    backwardTraversal(third);
    	}
    }

