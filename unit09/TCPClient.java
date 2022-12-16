package unit09;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
		final int port = 6666;

		try {
			// 创建一个Client Socket对象，并且指定服务器地址和端口号
			var socket = new Socket("127.0.0.1", port);
			// 创建一个输出流
			var out = new DataOutputStream(socket.getOutputStream());
			// 将一个double数发送给服务器
			double x = 3.1415926;
			out.writeDouble(x);
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
