package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("সার্ভার চালু হয়েছে: http://localhost:8080");
        while(true){
            Socket socket = server.accept();
            handleRequest(socket);
        }
    }
    private static void handleRequest(Socket clientSocket) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        // HTTP রিকুয়েস্ট পড়ুন
        String requestLine = in.readLine();
        System.out.println("রিকুয়েস্ট: " + requestLine);

        // HTTP রেস্পন্স পাঠান
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html; charset=UTF-8");
        out.println("\n<h1>আসসালামু আলাইকুম! 🚀</h1>");
        out.close();
    }
}
