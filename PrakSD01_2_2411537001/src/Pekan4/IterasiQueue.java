package Pekan4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IterasiQueue {
    public static void main(String args[]) {
        Queue<String> q = new LinkedList<>();
        
        q.add("Praktikum");
        q.add("Struktur");
        q.add("Data");
        q.add("Dan");
        q.add("Algoritma");

        Iterator<String> iterator = q.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}