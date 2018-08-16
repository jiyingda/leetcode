package jyd.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient{
    public static void main(String... args) throws IOException {
        int port = 55533;
        String host = "127.0.0.1";
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message = "hello i am jiyingda";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("get message from server " + sb.toString());
        inputStream.close();
        outputStream.close();
        socket.close();
    }

}
