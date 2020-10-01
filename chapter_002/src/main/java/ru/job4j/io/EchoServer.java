package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean isExit = false;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!isExit) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    boolean strIsEmpty = false;
                    while (!strIsEmpty) {
                        str = in.readLine();
                        if (str.contains("Bye")) {
                            isExit = true;
                        }
                        strIsEmpty = str.isEmpty();
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}
