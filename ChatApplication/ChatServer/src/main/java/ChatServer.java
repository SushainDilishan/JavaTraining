import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private int port;
    private Set<String> ChatUsers = new HashSet<>();
    private Set<ClientThreads> clientThreads = new HashSet<>();

    public ChatServer(int port){
        this.port = port;
    }

    public void initiate(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Chat port is"+ port);

                while (true){
                    Socket socket = serverSocket.accept();
                    System.out.println("New User Is connected");
                    ClientThreads clientThreadss = new ClientThreads(socket, this);
                    clientThreads.add(clientThreadss);
                }
        }catch (IOException ex){


        }
    }


}
