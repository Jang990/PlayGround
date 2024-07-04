package com.tutorial.java.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Start My Socket Server");
        try (ServerSocket socket = new ServerSocket(8080)) {
            while (true) {
                System.out.println("1 - Accept");
                Socket client = socket.accept();
                System.out.println("2 - Accepted And Go");
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
        String requestStr = readRequest(request);
        System.out.println(requestStr);
        String responseStr = createResponse("Hello World");
        response.write(responseStr.getBytes(StandardCharsets.UTF_8));
    }

    private static String createResponse(String body) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\r\n");
        sb.append("Content-Type: text/plain\r\n");
        sb.append("Connection: close\r\n");
        sb.append("\r\n");
        sb.append(body);
        return sb.toString();
    }

    private static String readRequest(InputStream request) throws IOException {
        /*
        이렇게 readAllBytes를 사용하는 방식은 메인 스레드를 블로킹시킴.
        EOF(End Of File)가 나올 때 까지 읽도록 만들어져 있는데
        상대방이 소켓을 닫을 때까지 EOF는 읽히지 않는다.
        그러므로 한 줄씩 가져와서 null이거나 empty일 때까지 읽고 다음으로 진행하는 방식으로 만들어야 한다.
        String line = new String(request.readAllBytes());

        관련 내용
        https://stackoverflow.com/questions/57964128/reading-bytes-from-an-inputstreamreader-goes-into-infinite-loop
         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(request));
        StringBuilder requestBuilder = new StringBuilder();
        String line;
        while (true) {
            line = reader.readLine();
            if(line == null || line.isEmpty())
                break;
            requestBuilder.append(line).append("\r\n");
        }
        return requestBuilder.toString();
    }
}
