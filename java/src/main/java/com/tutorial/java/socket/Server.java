package com.tutorial.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (ServerSocket socket = new ServerSocket(8080)) {
            while (true) {
                Socket client = socket.accept();
                try (
                        InputStream request = client.getInputStream();
                        OutputStream response = client.getOutputStream()
                ) {
                    process(request, response);
                } finally {
                    client.close();
                    Thread.sleep(1000);
                }
            }
        }
    }

    private static void process(InputStream request, OutputStream response) throws IOException {
        System.out.println(new String(request.readAllBytes()));
        String message = "Hello, World!";
        response.write(message.getBytes());
    }
}
