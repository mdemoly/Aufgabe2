package aufgaben;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Aufgabe3 {
	
	private static int[] N = new int[] {15, 77, 123};

	public static void main(String[] args) throws FileNotFoundException {
	
		int[] numbers = new int[] {4,2,3,9,1,8,6,5,7,0};
		
		aufgabe3_b_bubbleSort(numbers);
		aufgabe3_a_binarySearch(numbers, 11);
		aufgabe3_c_2powN();
		
	}
	
	public static double log2(int x) {
		return Math.log(x) / Math.log(2);
	}
	
	public static double calculateRatioNPow2PlusN(int srcN, double srcTime, int tarN) {
		double powTimeSrc = srcN*srcN + srcN;
		double powTimeTar = tarN*tarN + tarN;
		
		return srcTime * powTimeTar / powTimeSrc;
	}
	
	public static double calculateRatioLog2(int srcN, double srcTime, int tarN) {
		double logTimeSrc = log2(srcN);
		double logTimeTar = log2(tarN);
		
		return srcTime * logTimeTar / logTimeSrc;
	}
	
	public static double calculateRatio2PowN(int srcN, double srcTime, int tarN) {
		double powTimeSrc = Math.pow(2, srcN);
		double powTimeTar = Math.pow(2, tarN);
		
		return srcTime * powTimeTar / powTimeSrc;
	}
	
	public static void aufgabe3_a_binarySearch(int[] haystack, int needle) throws FileNotFoundException {
		System.setOut(new PrintStream(new FileOutputStream("Aufgabe3_a.txt")));
		
		int left = 0;
		int right = haystack.length;
		int steps = 0;
		
		while(left < right) {
			int middle = (left+right)/2;
			steps++;
			// 6 => 3
			// 7 => 3
			
			if(haystack[middle] == needle) {
				System.out.println("Nummer " + needle + " wurde in array mit " + steps + " Schritte gefunden!");
				return;
			}
			else if(haystack[middle] > needle) {
				right = middle;
			}
			else {
				left = middle + 1;
			}
		}
		
		System.out.println("Nummer " + needle + " wurde in array mit " + steps + " Schritte nicht gefunden!");
		
		for(int n : N) {
			System.out.print("Laufzeit von log2(n) for n=" + n + ": ");
			System.out.println(calculateRatioLog2(10, 7.0, n) + " Sekunden");
		}
		
	}
	
	public static void aufgabe3_b_bubbleSort(int[] numbers) throws FileNotFoundException
	{
		System.setOut(new PrintStream(new FileOutputStream("Aufgabe3_b.txt")));
		
		// Bubble sort macht ungefahr N^2 Schritte
		for(int i = 0; i < numbers.length; i++) {
			for(int j = i+1; j < numbers.length; j++) {
				if(numbers[j] < numbers[i]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		// Die Ausgabe macht N Schritte
		System.out.println("----------- NACH DEM SORT -------------");
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		// Die ganze Komplexitat ist dann O(N^2 + N)
		
		for(int n : N) {
			System.out.print("Laufzeit von n^2+n for n=" + n + ": ");
			System.out.println(calculateRatioNPow2PlusN(10, 7.0, n) + " Sekunden");
		}
	}
	
	public static void aufgabe3_c_2powN() throws FileNotFoundException {
		System.setOut(new PrintStream(new FileOutputStream("Aufgabe3_c.txt")));
		for(int n : N) {
			System.out.print("Laufzeit von 2^n for n=" + n + ": ");
			System.out.println(calculateRatio2PowN(10, 7.0, n) + " Sekunden");
		}
	}

}
