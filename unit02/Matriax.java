/**
 * 
 */
package unit02;

/**
 * @author LJC
 *
 */
public class Matriax {

	public static void main(String[] args) {
		String[][] mat= {
			{"a","b","c","d"},
			{"x","y","z","1"},
			{"2"}
		};
		for(String[] is:mat) {
			for(String k:is) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i < mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}

	}

}
