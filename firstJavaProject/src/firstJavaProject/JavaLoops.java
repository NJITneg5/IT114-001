package firstJavaProject;

public class JavaLoops {
	public static void main(String[] args) {
		
		//Number 1
		int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//Number 2
		for(int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i] + " ");
		}
		
		//Number 3
			System.out.println("\n");
		for(int i = 0; i <numbers.length; i++)
		{
			if(numbers[i] % 2 == 0) 
			{
				System.out.print(numbers[i] + " ");
			}
		}
		
		//Number 4
		System.out.println("\nI used the modulus operator and to divide each number by 2. " + 
		"\nIf the remainder is 0, it's even. If the remainder is 1, it's odd.");
		
		/* Number 5
		 * I will submit the screenshot
		 * 
		 * Number 6 
		 * https://github.com/NJITneg5/IT114-001/blob/master/firstJavaProject/src/firstJavaProject/JavaLoops.java
		 * 
		 */ 
		
	}
}
