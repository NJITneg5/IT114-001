package firstJavaProject;

public class TestClass {

	public static void main(String[] args) {
		String dividend = "16", divisor = "9";
		float quotiont = Float.parseFloat(dividend) / Float.parseFloat(divisor);
		
		System.out.println(quotiont);
		
		if(quotiont%1 == 0) {
			System.out.println("Number is a whole number");
		}
		else {
			System.out.println("Number is not a whole number");
		}
	}
}
