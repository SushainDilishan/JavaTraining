import java.io.PrintWriter;
import java.net.Socket;

public class ClientThreads extends Thread{

    private Socket socket;
    private ChatServer chatServer;
    private PrintWriter printWriter;

public ClientThreads(Socket socket,ChatServer chatServer){

    this.socket = socket;
    this.chatServer = chatServer;

}

}
