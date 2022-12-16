/**
1.	Write a program. 
1) Reads two numbers then divide one by another; 
If the dividend is zero, throw an ArithmeticException 
object. 2) Modify the program and put the division 
into a separate function; Test the function. 
 * 
 */
package unit05;

import java.util.Scanner;

public class TestDivide {

	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		var divisor = scanner.nextInt();
		var dividend = scanner.nextInt();
		try {
			if(dividend == 0) {
				throw new ArithmeticException("The dividend is "+dividend);
			}
			var result = divisor/dividend;
			System.out.println(divisor+"/"+dividend+"="+result);
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error");
			System.out.println(e.getMessage());
		}
	}

}
