package unit09;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		//创建一个ServerSocket对象，并设置监听窗口为6666
		final int port = 6666;
		var ss = new ServerSocket(port);
		System.out.println("已成功监听port"+ port);
	    // 准备接收客户端的连接请求
		ServerSocket server;
		
	    Socket socket = ss.accept();
	    System.out.println("已成功监听接收客户端的连接请求"+ss.getInetAddress().getHostName()+" "+ss.getLocalPort());
	    
	    // 创建输入流
	    DataInputStream in = new DataInputStream(socket.getInputStream());
	    System.out.println("已成功建立输入流");
	    // 读取客户端发送来的double
	    double x = in.readDouble();
	    
	    // 打印客户端发来的double数
	    System.out.println(x);
	}

}
