import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class ChatServer {
    
	private int port;
    private Set<String> ChatUsers = new HashSet<>();
    private Set<ClientThreads> clientThreads = new HashSet<>();

   
    
    public ChatServer(int port){
        this.port = port;
    }
   
    private static final String KEYSTORE_LOCATION = "/home/Documents/Keys/ServerKeyStore.jks";
    private static final String KEYSTORE_PASSWORD = "123456";
    
    public void initiate(){
    	ServerSocketFactory factory = SSLServerSocketFactory.getDefault();
        try( SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(port)){
            System.out.println("Chat port is "+ port);

                while (true){
                    Socket socket = serverSocket.accept();
                    System.out.println("New User Is connected");
                    ClientThreads clientThreadss = new ClientThreads(socket, this);
                    clientThreads.add(clientThreadss);
                    clientThreadss.start();
                }
        }catch (IOException ex){
            System.out.println("Internal Server error"+ ex.getMessage());
            ex.printStackTrace();
        }


    }
    public static void main(String[] args){
    	
    	 System.setProperty("javax.net.ssl.keyStore", KEYSTORE_LOCATION);
         System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASSWORD);
         
        if (args.length<1){
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }
        int port = Integer.parseInt(args[0]);
        ChatServer chatServer = new ChatServer(port);
        chatServer.initiate();


    }
    void broadcast(String msg,ClientThreads excludeClient){
        for (ClientThreads client: clientThreads){

            if (client !=excludeClient){
                client.sendMessage(msg);
            }
        }

    }
    void addClient(String clientName){
            ChatUsers.add(clientName);

    }

    void removeClient(String clientName,ClientThreads user){
        boolean removed = ChatUsers.remove(clientName);
        if(removed) {
            clientThreads.remove(user);

            System.out.println(" User " + clientName + " has left");

        }
    }

    public Set<String> getChatUsers() {

        return this.ChatUsers;
    }
    boolean hasUsers(){
        return this.ChatUsers.isEmpty();
    }

}
