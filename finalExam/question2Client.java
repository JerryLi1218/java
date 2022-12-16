package finalExam;

import java.net.*;
import java.util.Random;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.*;

public class question2Client {

	public static void main(String [] args) throws AWTException{
		final String serverName = "127.0.0.1";
        final int port = 8888;
        Robot r = new Robot();
	      try
	      {
	         System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
	         Socket client = new Socket(serverName, port);
	         System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);

	 
	         out.writeUTF("Hello from " + client.getLocalSocketAddress());
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in = new DataInputStream(inFromServer);
	         System.out.println("服务器响应： " + in.readUTF());
	         
	         
	         var outRNumber = new DataOutputStream(client.getOutputStream());
	         for (int i = 0; i < 10; i++) {
				//向服务器发送一个随机数
				outRNumber.writeDouble((double) Math.random());
				System.out.println((i+1) + "random number sent to server");
				//延迟一秒执行下一个
				r.delay(1000);
			}	         
	        

	         
	         //client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	   }

}
