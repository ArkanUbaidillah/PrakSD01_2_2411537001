package Pekan2;
import java.util.ArrayList;
import java.util.Scanner;

public class latihan2parkirmobil {

    // Class Mobil
    static class Mobil {
        private String platNomor;

        public Mobil(String platNomor) {
            this.platNomor = platNomor;
        }

        public String getPlatNomor() {
            return platNomor;
        }
    }

    // Class Parkiran
    static class Parkiran {
        private ArrayList<Mobil> daftarMobil = new ArrayList<>();

        public void tambahMobil(String platNomor) {
            daftarMobil.add(new Mobil(platNomor));
            System.out.println("Mobil dengan plat " + platNomor + " berhasil ditambahkan.");
        }

        public void keluarkanMobil(String platNomor) {
            for (int i = 0; i < daftarMobil.size(); i++) {
                if (daftarMobil.get(i).getPlatNomor().equalsIgnoreCase(platNomor)) {
                    daftarMobil.remove(i);
                    System.out.println("Mobil dengan plat " + platNomor + " telah dikeluarkan.");
                    return;
                }
            }
            System.out.println("Mobil dengan plat " + platNomor + " tidak ditemukan.");
        }

        public void tampilkanParkiran() {
            if (daftarMobil.isEmpty()) {
                System.out.println("Parkiran kosong.");
            } else {
                System.out.println("=== Daftar Mobil di Parkiran ===");
                for (Mobil mobil : daftarMobil) {
                    System.out.println("- " + mobil.getPlatNomor());
                }
            }
        }

        public void cariMobil(String platNomor) {
            for (Mobil mobil : daftarMobil) {
                if (mobil.getPlatNomor().equalsIgnoreCase(platNomor)) {
                    System.out.println("Mobil dengan plat " + platNomor + " masih terparkir.");
                    return;
                }
            }
            System.out.println("Mobil dengan plat " + platNomor + " tidak ditemukan di parkiran.");
        }
    }

    // Main Program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Parkiran parkiran = new Parkiran();

        // Tambah 7 mobil awal
        String[] platAwal = {
            "BA1111AA", "BA2222BB", "BA3333CC",
            "BA4444DD", "BA5555EE", "BA6666FF", "BA7777GG"
        };
        for (String plat : platAwal) {
            parkiran.tambahMobil(plat);
        }

        while (true) {
            System.out.println("\n=== Menu Parkiran Mobil ===");
            System.out.println("1. Tambah mobil ke Parkiran");
            System.out.println("2. Keluarkan mobil dari Parkiran");
            System.out.println("3. Tampilkan isi Parkiran");
            System.out.println("4. Cari mobil di Parkiran");
            System.out.println("5. Keluar");
            System.out.print("Pilih Opsi: ");
            int opsi = input.nextInt();
            input.nextLine(); // membersihkan buffer newline

            switch (opsi) {
                case 1:
                    System.out.print("Masukkan plat nomor mobil: ");
                    String platMasuk = input.nextLine();
                    parkiran.tambahMobil(platMasuk);
                    break;
                case 2:
                    System.out.print("Masukkan plat nomor mobil yang keluar: ");
                    String platKeluar = input.nextLine();
                    parkiran.keluarkanMobil(platKeluar);
                    break;
                case 3:
                    parkiran.tampilkanParkiran();
                    break;
                case 4:
                    System.out.print("Masukkan plat nomor mobil yang dicari: ");
                    String platCari = input.nextLine();
                    parkiran.cariMobil(platCari);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem parkiran.");
                    input.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }
}
