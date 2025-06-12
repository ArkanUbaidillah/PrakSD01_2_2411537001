package Pekan8;

// Nama: Arkan Ubaidillah Warman
// NIM: 2411537001

public class TugasSortingLanjutan {
    public static void main(String[] args) {
        // Deret bilangan prima dari 1–50
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
                        31, 37, 41, 43, 47};

        System.out.print("Deret awal: ");
        printArray(primes);

        System.out.println("Algoritma: Bubble Sort");
        bubbleSort(primes);
        
        System.out.print("Hasil: ");
        printArray(primes);
    }

    // Algoritma Bubble Sort descending 
    public static void bubbleSort(int[] array) {
        int langkah = 1;
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // tuker kalau lebih kecil
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    System.out.print("Langkah " + langkah + ": ");
                    printArray(array);
                    langkah++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // buat nampilin cetak array nya
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

