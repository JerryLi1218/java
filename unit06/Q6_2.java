package unit06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Q6_2 {

	public static void main(String[] args) {
		var file1 = new File("file1.txt");
		var file2 = new File("file2.txt");
		
		try (var fileWriter = new FileWriter(file1);
				var printWriter = new PrintWriter(file2)) {
			char[] msg1 = "Hello,world!".toCharArray();
			char[] msg2 = {'h','e','l','l','o'};
			fileWriter.write(msg1);
			fileWriter.write("kitty");
			char msg3 = 'X';
			fileWriter.write(msg3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}

}
