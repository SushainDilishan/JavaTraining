import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.net.ssl.SSLSocket;

public class ClientThreadWrite extends  Thread {

        private PrintWriter writer;
        private SSLSocket socket;
        private ChatClient client;
        
      

    public ClientThreadWrite(SSLSocket socket, ChatClient client) {
            this.socket = socket;
            this.client = client;
        try{
            OutputStream ouput = socket.getOutputStream();
            writer = new PrintWriter(ouput,true);
        }catch (IOException e){
            System.out.println("Error getting output from Server: "+  e.getMessage());
            e.printStackTrace();
        }
    }

    public void run(){

        Console console = System.console();

        String userName = console.readLine("\nEnter User Name: ");
        client.setUserName(userName);
        writer.println(userName);

        String text;
        do {
            text = console.readLine("["+userName+"]:");
            writer.println(text);
        }while (!text.equals("bye"));

        try{
            socket.close();

        }catch (IOException e){
            System.out.println("Error Writing to Server" +e.getMessage());
        }
    }
}
