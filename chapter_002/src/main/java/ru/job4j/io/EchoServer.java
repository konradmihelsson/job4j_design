package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class EchoServer {

    private final Map<String, Consumer<String>> actions = new HashMap<>();

    private boolean isExit = false;
    private String resp;

    public EchoServer() {
        this.actions.put("Hello", this::hello);
        this.actions.put("Exit", this::exit);
    }

    private void hello(String req) {
        this.resp = "Hello my dear friend!";
    }

    private void exit(String req) {
        this.resp = "";
        this.isExit = true;
    }

    private void communicate(String req) {
        this.resp = req;
    }

    public static void main(String[] args) throws IOException {
        EchoServer echoServer = new EchoServer();
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!echoServer.isExit) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream()) {
                    HttpParser httpParser = new HttpParser(socket.getInputStream());
                    httpParser.parseRequest();
                    String str = httpParser.getParam("msg");
                    echoServer.actions.getOrDefault(str, echoServer::communicate).accept(str);
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(echoServer.resp.getBytes());
                }
            }
        }
    }
}
