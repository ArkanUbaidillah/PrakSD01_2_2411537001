package Pekan4;

import java.util.*;

class Pelanggan {
    String id;
    int jumlahPesanan;

    public Pelanggan(String id, int jumlahPesanan) {
        this.id = id;
        this.jumlahPesanan = jumlahPesanan;
    }
}

public class latihanPekan4 {

    public static void prosesAntrian(Queue<Pelanggan> antrian) {
        int waktuTotal = 0;

        while (!antrian.isEmpty()) {
            Pelanggan p = antrian.poll();
            int waktuMulai = waktuTotal + 1;
            waktuTotal += p.jumlahPesanan;
            System.out.println(p.id + " dilayani mulai menit ke-" + waktuMulai + 
                               " dan selesai dalam " + waktuTotal + " menit");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Pelanggan> antrian = new LinkedList<>();

        System.out.print("Masukkan jumlah pelanggan: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // Buang newline

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Masukkan ID dan jumlah pesanan (pisahkan dengan spasi): ");
            String[] data = scanner.nextLine().split(" ");
            String id = data[0];
            int jumlahPesanan = Integer.parseInt(data[1]);
            antrian.offer(new Pelanggan(id, jumlahPesanan));
        }

        System.out.println("\n=== Hasil Pelayanan Pelanggan ===");
        prosesAntrian(antrian);

        scanner.close();
    }
}
