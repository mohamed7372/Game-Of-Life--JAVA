package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int gen = 1;
	
	public static void main(String []args) {
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		int m = scanner.nextInt();
		
		Random random = new Random(s);
		
		String[][] arr = new String[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				boolean b = random.nextBoolean();
				if (b)
					arr[i][j] = "O";
				else
					arr[i][j] = " ";
			}
		}
		showCube(arr);
		generationXth(arr, m);
	}
	
	static String[][] nextGeneration(String[][] arr) {
		int n = arr.length;
		String nextArr[][] = new String[n][n];
		int gen;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				gen = 0;
				for (int p = -1; p <= 1; p++) {
					for (int k = -1; k <= 1; k++) {
						int r = i + p;
						int c = j + k;
						if (r < 0)
							r = n - 1;
						else if (r > n - 1)
							r = 0;
						if (c < 0)
							c = n - 1;
						else if (c > n - 1)
							c = 0;
						
						if (arr[r][c].equals("O") && (p != 0 || k != 0))
							gen++;
					}
				}
				if (gen == 3 || (gen == 2 && arr[i][j].equals("O")))
					nextArr[i][j] = "O";
				else
					nextArr[i][j] = " ";
			}
		}
		showCube(nextArr);
		return nextArr;
	}
	static void showCube(String[][] arr) {
		System.out.println("Generation #" + gen);
		System.out.println("Alive: " + alive(arr));
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
		gen++;
		System.out.println();
	}
	static String[][] generationXth(String[][] arr, int m) {
		if (m == 0)
			return arr;
		else {
			return generationXth(nextGeneration(arr), m - 1);
		}
	}
	static int alive(String[][] arr) {
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j].equals("O"))
					n++;
			}
		}
		return n;
	}
}