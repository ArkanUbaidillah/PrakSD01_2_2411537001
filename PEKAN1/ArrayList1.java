package PEKAN1;

import java.util.ArrayList;

public class ArrayList1 {

	public static void main(String[] args) {
		// size of the arraylist
		int n = 5;
		// declaring the arrraylist with initial size n
		ArrayList<Integer> arrli = new ArrayList<Integer>(n);
		//Appending new Elements at the end of the list 
		for (int i = 1; i <= n; i++)
			arrli.add(i);
		//Printing elements
		System.out.println(arrli);
		//Remove elements at index 3
		arrli.remove(3);
		//displaying the arraylist
		//after deletion
		System.out.println(arrli);
		//printing elementts one by one
		for (int i = 0; i < arrli.size(); i++)
			System.out.println(arrli.get(i) + "");

	}

}
