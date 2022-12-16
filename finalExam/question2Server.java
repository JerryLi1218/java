package finalExam;

import java.io.*;
import java.net.*;
import java.util.Random;

/*
 * 使用以下说明编写程序：
 * 1）编写一个带有TCP套接字的客户端程序，
 * 它每1秒向服务器发送一个随机数。请注意使用异常处理。无需线程。
 * 2）编写一个带有TCP套接字的多线程服务器程序。
 * 服务器侦听端口 8888。当客户端连接到服务器时，
 * 服务器会创建一个新线程来为客户端提供服务。
 * 在线程中，程序接收号码，将其保存到文件中并将其打印在屏幕上
 */

public class question2Server extends Thread
{
   private ServerSocket serverSocket;
   
   public question2Server(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
   }
 
   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            

            
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress());
            
            // 拿到一个输入流
            var inNumber = new DataInputStream(server.getInputStream());
            for (int i = 0; i < 10; i++) {
				// 读取客户端发来的信息
				var number = inNumber.readDouble();
				// 显示
				System.out.println("Server receives: " + number);
			}
            
            
            //server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args){
	   final String serverName = "127.0.0.1";
       final int port = 8888;
      try
      {
         Thread t = new question2Server(port);
         t.run();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
