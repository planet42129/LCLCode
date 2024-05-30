package com.yhh.practice.network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author hyh
 * @date 2024/5/13
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("server start");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("connect success, from " + socket.getRemoteSocketAddress());
            Thread t = new SocketHandler(socket);
            t.start();
        }
    }
}
class SocketHandler extends Thread{
    Socket socket;
    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream input = this.socket.getInputStream()) {
            try (OutputStream output = this.socket.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.socket.close();
            } catch (IOException ioe) {
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        writer.write("hello\n");
        writer.flush();
        for (;;) {
            String s = reader.readLine();
            if (s.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok: " + s + "\n");
            writer.flush();
        }
    }
}