import java.io.*;
import java.net.Socket;

public class ClientThreads extends Thread{

    private Socket socket;
    private ChatServer chatServer;
    private PrintWriter printWriter;
    private String clientName;

public ClientThreads(Socket socket,ChatServer chatServer,String clientName){

    this.socket = socket;
    this.chatServer = chatServer;
    this.clientName = clientName;

}
public void run(){

    try{

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = socket.getOutputStream();
         printWriter = new PrintWriter(outputStream, true);

         printUsers();



         String serverMessage = "New Client connected " + clientName;
         chatServer.broadcast(serverMessage,this);

         String clientMessage;

        do {
            clientMessage = reader.readLine();
            serverMessage = "[" + clientName+ "]: " + clientMessage;
            chatServer.broadcast(serverMessage, this);

        } while (!clientMessage.equals("bye"));

        chatServer.removeClient(clientName, this);
        socket.close();

        serverMessage = clientName + " has quitted.";
         chatServer.broadcast(serverMessage, this);



    }catch (IOException ex){
        System.out.println("ClientThread Error:"+ex.getMessage());
        ex.printStackTrace();
    }
}

     void printUsers() {
    if(chatServer.hasUsers()){

        printWriter.println("Connected Clients: "+ chatServer.getChatUsers());
    }else{
        printWriter.println("No other Clients Connected");
    }

    }
    void sendMessage(String message){
    printWriter.println(message);
    }

}
