package Pekan3;

import java.util.Scanner;
import java.util.Stack;

public class tugasPekan3 {
    // Inner class Buku
    static class Buku {
        private String judul;

        public Buku(String judul) {
            this.judul = judul;
        }

        public String getJudul() {
            return judul;
        }

        @Override
        public String toString() {
            return judul;
        }
    }

    // Stack untuk tumpukan buku
    private Stack<Buku> tumpukanBuku = new Stack<>();
    private Scanner scanner = new Scanner(System.in);

    // Konstruktor untuk menambahkan 7 buku awal
    public tugasPekan3() {
        tumpukanBuku.push(new Buku("Algoritma Dasar"));
        tumpukanBuku.push(new Buku("Struktur Data"));
        tumpukanBuku.push(new Buku("Basis Data"));
        tumpukanBuku.push(new Buku("Pemrograman Java"));
        tumpukanBuku.push(new Buku("Jaringan Komputer"));
        tumpukanBuku.push(new Buku("Sistem Operasi"));
        tumpukanBuku.push(new Buku("Kecerdasan Buatan"));
    }

    // Tambah buku ke tumpukan
    public void tambahBuku(String judul) {
        tumpukanBuku.push(new Buku(judul));
        System.out.println("Buku \"" + judul + "\" telah ditambahkan ke tumpukan.");
    }

    // Ambil buku teratas
    public void ambilBuku() {
        if (tumpukanBuku.isEmpty()) {
            System.out.println("Tumpukan kosong. Tidak ada buku yang bisa diambil.");
        } else {
            Buku diambil = tumpukanBuku.pop();
            System.out.println("Buku diambil: " + diambil.getJudul());
        }
    }

    // Lihat tumpukan buku
    public void lihatTumpukan() {
        if (tumpukanBuku.isEmpty()) {
            System.out.println("Tumpukan kosong.");
        } else {
            System.out.println("Tumpukan Buku Saat Ini:");
            for (int i = tumpukanBuku.size() - 1; i >= 0; i--) {
                System.out.println("- " + tumpukanBuku.get(i).getJudul());
            }
        }
    }

    // Cari buku berdasarkan judul
    public void cariBuku(String judul) {
        boolean ditemukan = false;
        for (Buku b : tumpukanBuku) {
            if (b.getJudul().equalsIgnoreCase(judul)) {
                ditemukan = true;
                break;
            }
        }

        if (ditemukan) {
            System.out.println("Buku \"" + judul + "\" ditemukan dalam tumpukan.");
        } else {
            System.out.println("Buku \"" + judul + "\" tidak ditemukan dalam tumpukan.");
        }
    }

    // Menu interaktif
    public void menu() {
        int pilihan;

        do {
            System.out.println("\n=== MENU PERPUSTAKAAN MINI ===");
            System.out.println("1. Tambah Buku ke Tumpukan");
            System.out.println("2. Ambil Buku Teratas");
            System.out.println("3. Lihat Tumpukan Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // flush newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    tambahBuku(judul);
                    break;
                case 2:
                    ambilBuku();
                    break;
                case 3:
                    lihatTumpukan();
                    break;
                case 4:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String cari = scanner.nextLine();
                    cariBuku(cari);
                    break;
                case 5:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 5);
    }

    // Method utama
    public static void main(String[] args) {
        tugasPekan3 p = new tugasPekan3();
        p.menu();
    }
}
