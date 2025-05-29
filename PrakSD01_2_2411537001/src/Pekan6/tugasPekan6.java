package Pekan6;

import java.util.Scanner;

public class tugasPekan6 {

    // Kelas ItemBelanja
    static class ItemBelanja {
        String nama;
        int kuantitas;
        String kategori;

        public ItemBelanja(String nama, int kuantitas, String kategori) {
            this.nama = nama;
            this.kuantitas = kuantitas;
            this.kategori = kategori;
        }

        @Override
        public String toString() {
            return nama + " (" + kuantitas + ") [" + kategori + "]";
        }
    }

    // Kelas Node
    static class Node {
        ItemBelanja data;
        Node prev;
        Node next;

        public Node(ItemBelanja data) {
            this.data = data;
        }
    }

    // Kelas DaftarBelanja
    static class DaftarBelanja {
        Node head;
        Node tail;

        public void tambahItem(String nama, int kuantitas, String kategori) {
            ItemBelanja item = new ItemBelanja(nama, kuantitas, kategori);
            Node newNode = new Node(item);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            System.out.println("Item berhasil ditambahkan!");
        }

        public void hapusItem(String nama) {
            Node current = head;
            while (current != null) {
                if (current.data.nama.equalsIgnoreCase(nama)) {
                    if (current == head) {
                        head = current.next;
                        if (head != null) head.prev = null;
                        else tail = null;
                    } else if (current == tail) {
                        tail = current.prev;
                        tail.next = null;
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    System.out.println("Item berhasil dihapus.");
                    return;
                }
                current = current.next;
            }
            System.out.println("Item dengan nama '" + nama + "' tidak ditemukan.");
        }

        public void tampilkanSemuaItem() {
            if (head == null) {
                System.out.println("Daftar belanja kosong.");
                return;
            }
            System.out.println("--- Daftar Belanja ---");
            Node current = head;
            while (current != null) {
                System.out.println("- " + current.data.toString());
                current = current.next;
            }
        }

        public void tampilkanPerKategori(String kategori) {
            Node current = head;
            boolean found = false;
            System.out.println("--- Item dalam kategori '" + kategori + "' ---");
            while (current != null) {
                if (current.data.kategori.equalsIgnoreCase(kategori)) {
                    System.out.println("- " + current.data.nama + " (" + current.data.kuantitas + ")");
                    found = true;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("Tidak ada item dalam kategori '" + kategori + "'.");
            }
        }

        public void cariItem(String nama) {
            Node current = head;
            while (current != null) {
                if (current.data.nama.equalsIgnoreCase(nama)) {
                    System.out.println("Item ditemukan: " + current.data.toString());
                    return;
                }
                current = current.next;
            }
            System.out.println("Item dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // Main Menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DaftarBelanja daftar = new DaftarBelanja();
        int pilihan;

        do {
            System.out.println("\n=== MENU DAFTAR BELANJA ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Tampilkan Semua Item");
            System.out.println("4. Tampilkan Item Berdasarkan Kategori");
            System.out.println("5. Cari Item");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // hapus newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan kuantitas: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine(); // hapus newline
                    System.out.print("Masukkan kategori: ");
                    String kategori = scanner.nextLine();
                    daftar.tambahItem(nama, qty, kategori);
                    break;
                case 2:
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String hapus = scanner.nextLine();
                    daftar.hapusItem(hapus);
                    break;
                case 3:
                    daftar.tampilkanSemuaItem();
                    break;
                case 4:
                    System.out.print("Masukkan kategori: ");
                    String kat = scanner.nextLine();
                    daftar.tampilkanPerKategori(kat);
                    break;
                case 5:
                    System.out.print("Masukkan nama item yang dicari: ");
                    String cari = scanner.nextLine();
                    daftar.cariItem(cari);
                    break;
                case 6:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
