import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        int portNumber = 4040;
        String hostNumber = "127.0.0.1";
        //InetAddress.getLocalHost();

        Scanner scan = new Scanner(System.in);

        try {
            //Socket clientSocket = server;
          //  ServerSocket serverSocket = new ServerSocket(portNumber);
            //serverSocket.accept();

            Socket clientSocket = new Socket(hostNumber, portNumber);
            while (clientSocket.isBound()) {

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                out.println(scan.nextLine());
                String message = in.readLine();
                System.out.println(message);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
