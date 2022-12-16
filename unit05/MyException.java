 package unit05;

import java.util.Scanner;

public class MyException {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		var dividend = scanner.nextInt();
		var divisor = scanner.nextInt();
		var Test = new MyException();
		
		setDivisor(divisor);
		
		try {
			var result = MyException.division(divisor,divisor);
			System.out.println(divisor+"/"+divisor+"="+result);
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error");
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("The finally statement is executed");
		}
	}
	public static void setDivisor(int mDivisor) {
		assert mDivisor != 0;
	}

	private static Object division(int divisor, int divisor2) {
		// TODO Auto-generated method stub
		return null;
	}

}
