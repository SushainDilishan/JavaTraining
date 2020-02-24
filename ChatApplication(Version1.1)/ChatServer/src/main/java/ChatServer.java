import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChatServer {
    private int port;
//    private Set<String> ChatUsers = new HashSet<>();
//    private Set<ClientThreads> clientThreads = new HashSet<>();
    private Map<String,ClientThreads> UserMap = new HashMap<String,ClientThreads>();

    public ChatServer(int port){
        this.port = port;
    }

    public void initiate(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Chat port is "+ port);

                while (true){
                    Socket socket = serverSocket.accept();
                    System.out.println("New User Is connected");
                    
                    InputStream inputStream = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String clientName = reader.readLine();
                    
                    addClient(clientName);
                    ClientThreads clientThreadss = new ClientThreads(socket, this, clientName);
                    //UserMap.add(clientThreadss);

                    UserMap.put(clientName, clientThreadss);
                    clientThreadss.start();
                }
        }catch (IOException ex){
            System.out.println("Internal Server error"+ ex.getMessage());
            ex.printStackTrace();
        }


    }
    public static void main(String[] args){
        if (args.length<1){
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }
        int port = Integer.parseInt(args[0]);
        ChatServer chatServer = new ChatServer(port);
        chatServer.initiate();


    }
    void broadcast(String msg,String excludeClient){
       UserMap.get(excludeClient).sendMessage(msg);

    }
    void addClient(String clientName,ClientThreads user){
    		UserMap.put(clientName, user);
           // ChatUsers.add(clientName);

    }

    void removeClient(String clientName,ClientThreads user){
        boolean removed = UserMap.remove(clientName,user);
        if(removed) {

           System.out.println(" User " + clientName + " has left");

        }
    }

    public Map<String,ClientThreads> getChatUsers() {

        return this.UserMap;
    }
    
    boolean hasUsers(){
        return this.UserMap.isEmpty();
    }

}
