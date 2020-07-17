package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String []args) {
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		
		Random random = new Random(s);
		
		String[][] arr = new String[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				boolean b = random.nextBoolean();
				if (b)
					arr[i][j] = "O";
				else
					arr[i][j] = " ";
				
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
}
