/**
 * 
 */
package unit01;
/**
 * @author LJC
 *
 */
public class TestRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[]a=new int[10];
		int[]b=new int[10];
		
		for(int i = 0;i<10;i++) {
			int t = (int)(Math.random() * 100);
			System.out.println(t);
		}
		
		int count = 10;
		do {
			int t=(int)(Math.random()*10);
			System.out.println(t);
			
		}while(count-->0);
	}
	
	public void BubbleSort(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
			if(arr[i]>arr[j]) {	
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				}
			}
		}
	}
	
	

}
