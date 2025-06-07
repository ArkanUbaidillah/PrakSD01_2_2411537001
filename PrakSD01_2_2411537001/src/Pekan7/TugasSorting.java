package Pekan7;

public class TugasSorting {
	//Arkan Ubaidillah Warman
	//
	    public static void main(String[] args) {
	     
	        char[] data = {
	            'z','y','x','w','v','u','t','s','r','q',
	            'p','o','n','m','l','k','j','i','h','g',
	            'f','e','d','c','b','a'
	        };
   
	        selectionSort(data, 0, 1); 
	        
	        for (int i = 0; i < data.length; i++) {
	            System.out.print(data[i]);
	            if (i != data.length - 1) {
	                System.out.print(" - ");
	            }
	        }
	    }

	    public static void selectionSort(char[] arr, int start, int count) {
	        for (int i = start; i < start + count - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < start + count; j++) {
	                if (arr[j] < arr[minIndex]) {
	                    minIndex = j;
	                }
	            }
	            // Tukar posisi
	            char temp = arr[i];
	            arr[i] = arr[minIndex];
	            arr[minIndex] = temp;
	        }
	    }
	}



