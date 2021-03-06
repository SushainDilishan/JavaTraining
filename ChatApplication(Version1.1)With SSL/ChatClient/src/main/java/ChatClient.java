import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ChatClient {
    private String hostname;
    private int port;
    private String userName;
	private Scanner scanner;
	
	  private static final String TRUSTSTORE_LOCATION = "/home/Documents/CA/ClientKeyStore.jks";
      private static final String TRUSTSTORE_PASSWORD = "123456";

//    public ChatClient(String hostname,int port) {
//
//        this.hostname = hostname;
//        this.port = port;
//    }


    public void initiate(){
    	
    	scanner = new Scanner(System.in);
    	
    	System.out.println("Welcome to Matrix\n "
    			+ "Enter This command to Connect to the Chat Room\n "
    			+ "Connect localhost/ip:port as Name");
    	
    	String response = scanner.nextLine();
    	
    	String[] parts = response.split("\\s+");
    	String[] connection = parts[1].split(":");
    	
    	userName = parts[3];
    	hostname = connection[0];
    	port = Integer.parseInt(connection[1]);
    	
        try {
        	SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        	SSLSocket socket = (SSLSocket)factory.createSocket(hostname,port);
        	
        	socket.startHandshake();
//            Socket socket = new Socket(hostname,port);
            System.out.println("Connected to Chat Room");

            new ClientThreadRead(socket,this).start();
            new ClientThreadWrite(socket,this).start();

        }catch (UnknownHostException ex){
            System.out.println("Host Server Not Found "+ex.getMessage());

        }
        catch (IOException e){
            System.out.println("Inpur or Output Error "+ e.getMessage());

        }
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
    	
    	 System.setProperty("javax.net.ssl.trustStore", TRUSTSTORE_LOCATION);
         System.setProperty("javax.net.ssl.trustStorePassword", TRUSTSTORE_PASSWORD);

//        if(args.length<2) return;
//
//        String hostname = args[0];
//        int port = Integer.parseInt(args[1]);
        
    	ChatClient client = new ChatClient();
        client.initiate();

    }
}
