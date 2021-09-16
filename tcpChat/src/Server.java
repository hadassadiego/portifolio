import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        int portNumber = 4040;
        Scanner scan = new Scanner(System.in);
        System.out.println("What's up client");

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            while (clientSocket.isBound()) {

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


                String message = in.readLine();
                System.out.println(message);
                out.println(scan.nextLine());

            }
            } catch(IOException e){
                e.printStackTrace();
            }

    }
}
