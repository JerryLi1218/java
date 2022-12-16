/**
 * 
 */
package unit02;

/**
 * @author LJC
 *
 */
public class TestReverse {
	
		
	public static void main(String[] args) {
		int[] x = new int[6];
		for(int i=0;i <x.length;i++) {
			x[i] = (int)(Math.random()*1000);
		}
		var algo = new Algo();
		algo.print(x);
		algo.print(algo.reverse(x));
	}

}

class Algo{
	public int[] reverse(int[] arr) {
		int t=0;
		for(int i=0;i<arr.length/2 ;i++ ) {
			t = arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i] = t;
		}
		return arr;
	}
	public void print(int[] arr) {
		for(var k:arr) {
			System.out.print(k+" ");
		}
		System.out.println(" ");
	}
}
