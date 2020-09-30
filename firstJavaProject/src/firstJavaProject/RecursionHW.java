package firstJavaProject;

import java.util.Scanner;

public class RecursionHW {
	
	/*public class RecursionHW {
  
	public static int sum(int num) {
		if (num > 0) {
			return num + sum(num - 1);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(sum(10));
	}
}
	*/
	static boolean isRunning = true;
	
	public static int sum(int num) {
		int total = 0;
		
		if(num == 0) {
			isRunning = false;
			return 0;
		}
		
		while (num > 0) {
			total += num;
			if(num == 1)
				System.out.print(num + " = ");
			else
				System.out.print(num + " + ");
			num--;
		}
		return total;
	}
	
	public static void main(String[] args) {
		
		int input;
		Scanner kb = new Scanner(System.in);
		
		while(isRunning) {
			System.out.println("Please pick a number for me to calculate the sum of it and all lower numbers (Put 0 to quit): ");
			input = kb.nextInt();
			System.out.println(sum(input));
		}
		kb.close();
	}
}
