/**
 * 
 */
package unit02;

/**
 * @author LJC
 *
 */
public class TestSwap {

	public static int[] swapInt(int x,int y) {
		int temp = x;
		x = y;
		y = temp;
		return new int[] {x,y};
	}
	public static Integer[] swapInteger(Integer x,Integer y) {
		Integer temp = x;
		x = y;
		y = temp;
		return new Integer[] {x,y};
	}
	
	
	public static void main(String[] args) {
		int num1 = 8;
		int num2 = 10;
		int[] swap1 = swapInt(num1,num2);
		num1 = swap1[0];
		num2 = swap1[1];
		System.out.println("after swap int "+num1+" "+num2);
		
		Integer num3 = 5;
		Integer num4 = 6;
		Integer[] swap2 = swapInteger(num3,num4);
		swapInteger(num3,num4);
		num3 = swap2[0];
		num4 = swap2[1];
		System.out.println("after swap Integer "+num3+" "+num4);
	}

}
