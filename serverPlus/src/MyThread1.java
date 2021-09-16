import java.io.IOException;

public class MyThread1 implements Runnable{

    Server server = new Server();

    @Override
    public void run() {
       server.server();


    }
}
