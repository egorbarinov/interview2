package com.egorbarinov.demoapp.clientSocket;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class clientSocket {

    public static String sendRequest(String host, int port, String method, String address, String protocol, String connectionStatus, String contentType) throws IOException {
        try(Socket socket = new Socket(host, port)) {
            String requestMessage = method + " " + address + " " + protocol + "\r\n" +
                    "Host: " + host + ":" + port + "\r\n" +
                    "Accept: " + contentType + "\r\n" +
                    "Connection: " + connectionStatus + "\r\n" +
                    "Content-Type: " + contentType + "\r\n" +
                    "\r\n";
            socket.getOutputStream().write(requestMessage.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();

            StringBuilder response = new StringBuilder();
            byte[] buffer = new byte[8192];

            while ((socket.getInputStream().read(buffer)) != -1) {
                for (int i = 0; i < buffer.length; i++) {
                    response.append((char)buffer[i]);
                }
            }

            return response.toString();

        }
    }

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8189;
        String get = "GET";
        String post = "POST";
        String address1 = "/demo-app/hello";
        String address2 = "/demo-app/findAll";
        String protocol = "HTTP/1.1";
        String connectionStatus = "close";
        String contentType = "text/plain;charset=UTF-8";
        String contentType2 = "application/json";
        System.out.println(sendRequest(host, port, get, address1, protocol, connectionStatus, contentType)); // <h1>Hello, User<h1/>
        System.out.println(sendRequest(host, port, get, address2, protocol, connectionStatus, contentType2));
        // не смог разобраться, почему ответ пришел два раза.. и что за значения 7b и 0....
        //7b
        //[{"id":1,"name":"Egor Barinov","age":38},{"id":2,"name":"Vasya Lozhkin","age":45},{"id":3,"name":"Vasya Oblomov","age":30}]
        //0
        //
        //
        //[{"id":1,"name":"Egor Barinov","age":38},{"id":2,"name":"Vasya Lozhkin","age":45},{"id":3,"name":"Vasya Oblomov","age":30}]


        // изучил некоторую библиотеку по формированию запросов и получению ответов. Интересно то, что писалась под Kotlin.
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8189/demo-app/findAll")
                .method("GET", null)
                .build();
        Response response =client.newCall(request).execute();
        System.out.println(Objects.requireNonNull(response.body()).string());
    }

}


