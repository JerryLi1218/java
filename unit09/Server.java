package unit09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Create a TCP server which listens on 6666 port and waiting to receive a double number; then create a TCP client which
 *  send a double number to the server. When the server receives the double number, print it out.
 */
public class Server {
    public static void main(String[] args) {
        final int port = 6666;
        try (// 首先要创建一个ServerSocket
        ServerSocket ss = new ServerSocket(port)) {
            System.out.println("Server listening on " + port);
            // 等待客户端连接
            Socket socket = ss.accept();
            System.out.println("Connection from: "+ socket.getInetAddress().getHostAddress() + ":"
                + socket.getPort());

            // 拿到一个输入流
            var in = new DataInputStream(socket.getInputStream());
            // 读取客户端发来的信息
            var number = in.readDouble();
            // 显示
            System.out.println("Server receives: "+number);

            // 将number发回给客户端
            var out = new DataOutputStream(socket.getOutputStream());
            out.writeDouble(number);
            System.out.println("Server send back to client: "+number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
