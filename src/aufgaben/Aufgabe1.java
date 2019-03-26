package aufgaben;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Aufgabe1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		aufgabe1_b();
		
		System.setOut(new PrintStream(new FileOutputStream("Aufgabe1_cd.txt")));
		aufgabe1_d(5);
		aufgabe1_d(10);
		aufgabe1_d(20);
		aufgabe1_d(100);
	}
	
	public static boolean qualified(int[] grades) {
		for(int grade : grades) {
			if(grade > 3) {
				return false;
			}
		}
		return true;
	}
	
	public static void aufgabe1_b() throws FileNotFoundException {
		System.setOut(new PrintStream(new FileOutputStream("Aufgabe1_b.txt")));
		System.out.println("Minimale Anzahl der Schleifendurchlaufe ist 1 und maximale N.");
		System.out.println("Minimale Anzahl: {4, 1, 1, 1}");
		qualified(new int[]{4, 1, 1, 1});
		System.out.println("Maximale Anzahl: {2, 1, 2, 1}");
		qualified(new int[]{2, 1, 2, 1});		
	}
	
	public static void aufgabe1_d(int n) throws FileNotFoundException {
		
		double result = Math.pow(0.6, n)*(n-1);
		for(int i = 0; i < n; i++) {
			result += Math.pow(0.6, i)*0.4*i;
		}
		
		System.out.println("Durchschnittliche Anzahl fuer " + n + ": " + result);
	}

}
