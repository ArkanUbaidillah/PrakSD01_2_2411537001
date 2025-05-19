package Pekan1;

import java.util.ArrayList;

public class ArraylistGetElemen {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		//Add number
		list.add(9);
		list.add(5);
		list.add(6);
		System.out.println(list);
		//get method 
		Integer n = list.get(1);
		System.out.println("Pada indeks ke 1 angkanya adalah " + n);
		

	}

}
