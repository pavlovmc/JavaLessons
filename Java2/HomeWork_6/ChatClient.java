package HomeWork_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String host = "localhost";
    private static final int port = 3456;

    private static DataInputStream in;
    private static DataOutputStream out;
    private static boolean flag;

    public static void main(String[] args) {
        try {
            openConnection();
            Scanner scanner = new Scanner(System.in);
            while(flag) {
                String str = scanner.nextLine();
                try{
                    if (str.equals("/exit")) {
                        out.writeUTF(str);
                        flag = false;
                        System.exit(0);
                    }
                    System.out.println("Client: " + str);
                    out.writeUTF(str);
                }
                catch (IOException e) {
                    flag = false;
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    private static void openConnection() throws IOException {
        Socket socket;
        socket = new Socket(host, port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        flag = true;
        new Thread(()->{
            while(true) {
                try {
                    String msg = in.readUTF();
                    if(msg.equals("/exit")) {
                        System.exit(0);
                        flag = false;
                    }
                    System.out.println("Server: " + msg);
                }
                catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        }).start();
    }
}
