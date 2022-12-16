package unit09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/* Create a TCP server which listens on 6666 port and waiting to receive a double number; 
 * then create a TCP client which send a double number to the server. When the server receives
 *  the double number, print it out. 
 */
public class Client {
    public static void main(String[] args) {
        final String server = "127.0.0.1";
        final int port = 6666;

        try (// 创建一个 client socket，用于连接服务器
        var socket = new Socket(server, port)) {
            // 获取一个输出流
            var out = new DataOutputStream(socket.getOutputStream());

            // 向服务器发送一个double数字
            out.writeDouble(42.01);
            System.out.println("Send to server: "+ 42.01);

            // 获取一个输入流，并且从流中读取服务器发来的信息
            var in = new DataInputStream(socket.getInputStream());
            var number = in.readDouble();
            System.out.println("Receives from server: "+number);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
