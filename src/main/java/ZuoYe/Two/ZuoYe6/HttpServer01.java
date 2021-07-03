package ZuoYe.Two.ZuoYe6;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author JuYang
 * @date 2021年07月03日12:11
 */
public class HttpServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        try {
            while (true){
                Socket socket = serverSocket.accept();
                service(socket);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void service (Socket socket){
        Writer out;
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Context-Type:text/html;charset=utf-8");
            String body ="hello,nio1";
            printWriter.println("Content-Length:"+body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
