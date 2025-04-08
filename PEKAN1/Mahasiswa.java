package Pekan1;

public class Mahasiswa {
    String nim;
    String nama;
    String prodi;

    Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Prodi: " + prodi;
    }
}


