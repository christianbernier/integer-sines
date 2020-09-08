import java.math.BigDecimal;
import java.util.Scanner;

public class MainProgram {
	public static int PRECISION = 100;
	public static int TEST_UP_TO = 10000;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to the integer sine calculator v. 1.0.1");
		System.out.println("This program was written by Christian Bernier");
		System.out.println("--");
		System.out.println("Finds which integer sine is closest to 1 in a given range.");
		System.out.print("\nHow many decimal places would you like the number to go to? ");
		PRECISION = input.nextInt();
		System.out.print("\nWhat number would you like to test up to? ");
		TEST_UP_TO = input.nextInt();
		
		
		Trig trigFuncs = new Trig(PRECISION);
		BigDecimal largest = new BigDecimal(0);
		System.out.println("\n\nBeginning search...");
		for(int i = 0; i < TEST_UP_TO; i++) {
			BigDecimal testing = new BigDecimal(i); 
			BigDecimal sine = trigFuncs.sin(testing);
			
			int done = (int) Math.round((double) i * 100 / TEST_UP_TO);
			if(TEST_UP_TO >= 10 && i % (TEST_UP_TO / 10) == 0) {
				System.out.printf("%2d",  done);
				System.out.println("% done with search");
			}
			
			if(sine.compareTo(largest) > 0) {
				largest = sine;
				System.out.printf("%2d", done);
				System.out.println("% done with search - sin(" + i + ") = " + largest);
			}
		}
		System.out.println("Done with search.");
	}
//		BigDecimal largest = new BigDecimal(0);
//		int num = 1000;
//		System.out.println("beginning search.");
//		for(int i = 0; i < num; i++) {
////			double sine = Math.sin(i);
//			BigDecimal sin = sin(i);
//			
//			int done = (int) Math.round((double) i * 100 / num);
//			if(num >= 10 && i % (num / 10) == 0) {
//				System.out.printf("%2d",  done);
//				System.out.println("% done with search");
//			}
//			if(sin.compareTo(largest) > 0) {
//				largest = sin;
//				
//				System.out.printf("%2d", done);
//				System.out.println("% done search - sin(" + i + ") = " + largest + "\n");
//			}
//		}
//		System.out.println("done with search.");
//	}
//	
//	public static BigDecimal sin(int i) {
//		BigDecimal ret = new BigDecimal(0);
//		for(int a = 1; a <= sinePrecision; a += 2) {
//			BigDecimal newPart = new BigDecimal(i);
//			newPart = newPart.pow(a);
//			newPart = newPart.divide(factorial(a), PRECISION, BigDecimal.ROUND_HALF_UP);
//			if((a - 1) % 4 == 0) {
//				ret = ret.add(newPart);
//			} else {
//				ret = ret.subtract(newPart);
//			}
//		}
//		return ret;
//	}
//	
//	public static BigDecimal factorial(int a) {
//		if(a == 1) {
//			return new BigDecimal(1);
//		} else {
//			BigDecimal b = new BigDecimal(a);
//			return b.multiply(factorial(a - 1));
//		}
//	}

}