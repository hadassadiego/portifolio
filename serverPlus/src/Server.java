import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    int portNumber = 4949;

    private String typeOfResources;


    private String text = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: <file_byte_size> \r\n" +
            "\r\n";
    //header que permite saber que tipo de dado esta a ser enviado

    private String image = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: image/png \r\n" +
            "Content-Length: <file_byte_size> \r\n" +
            "\r\n";

    private String error = "HTTP/1.0 404 Not Found\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: <file_byte_size> \r\n" +
            "\r\n";

    private String path;

    public void server() {
        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);

            while (true) {
                Socket client = serverSocket.accept();
                Thread thread = new Thread(new MyThread1());
                thread.start();

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                //Buffered le o maior, inputStream le o menor

                String string = bufferedReader.readLine();

                System.out.println(string);
                typeOfResources = string.split(" ")[1]; // busca a posicao do array que quero "usar"


                switch (typeOfResources) {
                    case "/text":
                        typeOfResources = text;
                        path = "/Users/codecadet/Desktop/exercicios/webServer/Batata.html";
                        break;

                    case "/image":
                        typeOfResources = image;
                        path = "/Users/codecadet/Desktop/exercicios/webServer/homerSimpson.png";
                        break;

                    default:
                        typeOfResources = error;
                        path = "/Users/codecadet/Desktop/exercicios/webServer/Error.html";
                        break;

                }
                out.write(typeOfResources);
                out.flush();

                FileInputStream file = new FileInputStream(path);
                byte[] buffer = new byte[1024];
                int numOfBytes;

                while ((numOfBytes = file.read(buffer)) != -1) {
                    client.getOutputStream().write(buffer, 0, numOfBytes);
                }
                //busca output

                file.close();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


        }

