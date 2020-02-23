import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.net.ssl.SSLSocket;

public class ClientThreadRead extends Thread {

    private BufferedReader reader;
    private  ChatClient chatClient;
   
    public ClientThreadRead(SSLSocket socket, ChatClient chatClient) {
        this.chatClient = chatClient;

        try{
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        }catch (IOException ex){
            System.out.println("Error getting Input " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run(){
        while (true){
            try{
                String response = reader.readLine();
                System.out.println("\n" + response);

                if (chatClient.getUserName() != null){
                    System.out.println("["+chatClient.getUserName()+"]: ");
                }
            }catch (IOException e){
                System.out.println("Error in reading server Input" + e.getMessage());
                e.printStackTrace();
                break;
            }
        }
    }


}
