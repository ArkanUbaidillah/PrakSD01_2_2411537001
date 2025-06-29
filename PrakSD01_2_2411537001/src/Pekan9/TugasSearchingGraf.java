package Pekan9;

import java.util.*;

public class TugasSearchingGraf {
    private Map<String, List<String>> graph = new HashMap<>();
    private List<String> route = new ArrayList<>();
    private int step = 1;

    public TugasSearchingGraf() {
        // Inisialisasi graf tak berarah
    	graph.put("A", Arrays.asList("B", "C"));
    	graph.put("B", Arrays.asList("A", "D"));
    	graph.put("C", Arrays.asList("A", "D", "E"));
    	graph.put("D", Arrays.asList("B", "C", "F"));
    	graph.put("E", Arrays.asList("C", "F", "H"));
    	graph.put("F", Arrays.asList("D", "E", "G"));
    	graph.put("G", Arrays.asList("F", "H"));
    	graph.put("H", Arrays.asList("E", "G"));

    }

    public void search(String startNode, String goalNode) {
        Set<String> visited = new HashSet<>();
        System.out.println("Nama: Arkan Ubaidillah Warman");
        System.out.println("NIM: 2411537001");
        System.out.println();
        System.out.println("Node awal: " + startNode);
        System.out.println("Node tujuan: " + goalNode);
        System.out.println("Algoritma: DFS");
        System.out.println();

        dfs(startNode, goalNode, visited);

        System.out.println();
        System.out.print("Rute: ");
        for (int i = 0; i < route.size(); i++) {
            System.out.print(route.get(i));
            if (i < route.size() - 1) {
                System.out.print(" → ");
            }
        }
    }

    private boolean dfs(String current, String goal, Set<String> visited) {
        visited.add(current);
        System.out.println("Langkah " + step + ": Kunjungi " + current);
        step++;
        route.add(current);

        if (current.equals(goal)) {
            System.out.println("Tujuan " + goal + " ditemukan");
            return true;
        }

        List<String> neighbors = graph.getOrDefault(current, new ArrayList<>());
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, goal, visited)) {
                    return true;
                }
            }
        }

        route.remove(route.size() - 1); // backtrack jika perlu
        return false;
    }

    public static void main(String[] args) {
        TugasSearchingGraf graf = new TugasSearchingGraf();
        graf.search("A", "G");
    }
}
