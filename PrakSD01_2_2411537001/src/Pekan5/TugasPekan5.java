package Pekan5;

import java.util.Scanner;

public class TugasPekan5 {
    // Node untuk Single Linked List
    static class Node {
        int noAntrian;
        String nama;
        String keluhan;
        Node next;
        
        Node(int noAntrian, String nama, String keluhan) {
            this.noAntrian = noAntrian;
            this.nama = nama;
            this.keluhan = keluhan;
            this.next = null;
        }
    }
    
    // Pointer ke node pertama
    private Node head;
    
    // Constructor
    public TugasPekan5() {
        this.head = null;
    }
    
    // 1. Menambahkan pasien ke akhir antrian
    public void tambahPasien(int noAntrian, String nama, String keluhan) {
        Node newNode = new Node(noAntrian, nama, keluhan);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Data pasien berhasil ditambahkan!");
    }
    
    // 2. Menampilkan seluruh data pasien dalam antrian
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        
        System.out.println("--- Daftar Antrian Pasien ---");
        Node current = head;
        int urutan = 1;
        
        while (current != null) {
            System.out.println(urutan + ". [" + current.noAntrian + "] " + 
                             current.nama + " - " + current.keluhan);
            current = current.next;
            urutan++;
        }
    }
    
    // 3. Menghapus pasien paling depan dalam antrian
    public void hapusPasienPertama() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada pasien yang bisa dilayani.");
            return;
        }
        
        String namaPasien = head.nama;
        head = head.next;
        System.out.println("Pasien dengan nama " + namaPasien + " telah dilayani (dihapus dari antrian).");
    }
    
    // 4. Mencari dan menampilkan informasi pasien berdasarkan nama
    public void cariPasien(String nama) {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        
        Node current = head;
        int posisi = 1;
        boolean ditemukan = false;
        
        while (current != null) {
            if (current.nama.equalsIgnoreCase(nama)) {
                System.out.println("Pasien ditemukan:");
                System.out.println("Posisi dalam antrian: " + posisi);
                System.out.println("Nomor Antrian: " + current.noAntrian);
                System.out.println("Nama: " + current.nama);
                System.out.println("Keluhan: " + current.keluhan);
                ditemukan = true;
                break;
            }
            current = current.next;
            posisi++;
        }
        
        if (!ditemukan) {
            System.out.println("Pasien dengan nama \"" + nama + "\" tidak ditemukan dalam antrian.");
        }
    }
    
    // 5. Mengecek apakah antrian kosong
    public boolean isEmpty() {
        return head == null;
    }
    
    // 6. Menghitung jumlah pasien dalam antrian
    public int hitungPasien() {
        int count = 0;
        Node current = head;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    // Method untuk menampilkan menu
    public static void tampilkanMenu() {
        System.out.println("\n=== SISTEM ANTRIAN PASIEN KLINIK ===");
        System.out.println("1. Tambah Pasien");
        System.out.println("2. Tampilkan Antrian");
        System.out.println("3. Layani Pasien (Hapus Antrian Pertama)");
        System.out.println("4. Cari Pasien");
        System.out.println("5. Jumlah Pasien");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu: ");
    }
    
    // Main method
    public static void main(String[] args) {
        TugasPekan5 antrian = new TugasPekan5();
        Scanner input = new Scanner(System.in);
        int pilihan;
        
        do {
            tampilkanMenu();
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan buffer
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int noAntrian = input.nextInt();
                    input.nextLine(); // Membersihkan buffer
                    
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = input.nextLine();
                    
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan = input.nextLine();
                    
                    antrian.tambahPasien(noAntrian, nama, keluhan);
                    break;
                    
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                    
                case 3:
                    antrian.hapusPasienPertama();
                    break;
                    
                case 4:
                    System.out.print("Masukkan nama pasien yang dicari: ");
                    String namaCari = input.nextLine();
                    antrian.cariPasien(namaCari);
                    break;
                    
                case 5:
                    int jumlah = antrian.hitungPasien();
                    System.out.println("Jumlah pasien saat ini: " + jumlah);
                    break;
                    
                case 6:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1-6.");
            }
            
        } while (pilihan != 6);
        
        input.close();
    }
}