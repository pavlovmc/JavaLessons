package HomeWork_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    public static void main(String[] args) {
        boolean flag;
        String str;
        DataOutputStream serverOutput = null;
        DataInputStream serverInput;

         Socket socket;
         try (ServerSocket serverSocket = new ServerSocket(3456)) {
             flag = true;
             System.out.println("Server ready...");
             socket = serverSocket.accept();
             System.out.println("New client is connected...");
             serverInput = new DataInputStream(socket.getInputStream());
             serverOutput = new DataOutputStream(socket.getOutputStream());
             Thread serverThread = new Thread(()-> {
                 while(true) {
                     try {
                         String msg = serverInput.readUTF();
                         if (msg.equals("/exit")) {
                             System.exit(0);
                         }
                         System.out.println("Client: " + msg);
                     } catch (IOException e) {
                         e.printStackTrace();
                         System.exit(0);
                     }
                 }
             });
             serverThread.start();
         } catch (IOException e) {
             flag = false;
             System.out.println("Server is down...");
             e.printStackTrace();
         }
        Scanner scanner = new Scanner(System.in);
         while(flag) {
             str = scanner.nextLine();
             try{
                 if (str.equals("/exit")) {
                     serverOutput.writeUTF(str);
                     flag = false;
                     System.exit(0);
                 }
                 System.out.println("Server: " + str);
                 serverOutput.writeUTF(str);
             }
             catch (IOException e) {
                 flag = false;
                 e.printStackTrace();
                 System.exit(0);
             }
        }
    }
}
