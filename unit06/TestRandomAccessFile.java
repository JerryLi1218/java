package unit06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {

	public static void main(String[] args) throws IOException {
		//创建文件
		File file = new File("testQuiz6_6.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		//实例化RandomAccessFile对象
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		//打开文件时指针位置在最前，即0
		System.out.println(raf.getFilePointer());

		//写入数据
		int[] num = {28, 14, 56, 23, 98};
		for (int i : num) {
			raf.writeInt(i);
		}
		
		//读取文件，在读取前需要通过seek()方法把文件指针移到最前
		raf.seek(0);
		for (int i = 0; i*4 < raf.length(); i++) {
			System.out.println(raf.readInt());
		}
		
		//操作结束后一定要关闭文件
		raf.close();
	}
}
