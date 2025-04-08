package PEKAN1;

import java.util.ArrayList;
import java.util.Scanner;


public class DaftarSiswa {
    private static ArrayList<String> daftarNamaSiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Nama Siswa");
            System.out.println("2. Tampilkan Daftar Nama Siswa");
            System.out.println("3. Hapus Nama Siswa");
            System.out.println("4. Cari Nama Siswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    tambahNamaSiswa(scanner);
                    break;
                case 2:
                    tampilkanDaftarNamaSiswa();
                    break;
                case 3:
                    hapusNamaSiswa(scanner);
                    break;
                case 4:
                    cariNamaSiswa(scanner);
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    private static void tambahNamaSiswa(Scanner scanner) {
        System.out.print("Masukkan nama siswa: ");
        String nama = scanner.nextLine();
        daftarNamaSiswa.add(nama);
        System.out.println("Nama siswa berhasil ditambahkan.");
    }

    private static void tampilkanDaftarNamaSiswa() {
        System.out.println("\nDaftar Nama Siswa:");
        if (daftarNamaSiswa.isEmpty()) {
            System.out.println("Tidak ada siswa dalam daftar.");
        } else {
            System.out.println("Daftar nama siswa: ");
            for (String nama : daftarNamaSiswa) {
            	System.out.println(nama);
          }
        }
    }

    private static void hapusNamaSiswa(Scanner scanner) {
        tampilkanDaftarNamaSiswa();
        System.out.print("Masukkan nama siswa yang ingin dihapus: ");
        String nama = scanner.nextLine();
        if (daftarNamaSiswa.remove(nama)) {
        	System.out.println("Nama siswa berhasil dihapus.");
        } else {
            System.out.println("Nama siswa tidak ditemukan.");
        }
    }

    private static void cariNamaSiswa(Scanner scanner) {
        System.out.print("Masukkan nama yang dicari: ");
        String nama = scanner.nextLine();
        if (daftarNamaSiswa.contains(nama)) {
        	System.out.println("Nama siswa ditemukan :"  + nama );
        }else {
        	System.out.println("Nama siswa tidak ditemukan");
            }
        }
     
        
    
}
