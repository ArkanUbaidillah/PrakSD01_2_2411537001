package Pekan3;

import java.util.Stack;

public class contohStack {

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<>();
		Integer[] a = {4, 8, 15, 16, 23, 42};
		for (int i =0; i<a.length; i++) {
			System.out.println("nilai A "+i+"= " + a[i]);
			test.push(a[i]);
		}
		System.out.println("size stacknya:" + test.size());
		System.out.println("paling atas:" + test.peek());
		System.out.println("nilainya: "+ test.pop());

	}

}
