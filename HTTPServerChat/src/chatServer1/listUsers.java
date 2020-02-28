package chatServer1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class listUsers implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {


        URI uri = httpExchange.getRequestURI();
        String s = uri.getRawQuery();

        String userName = s.substring(s.indexOf("=") + 1,s.length());
        System.out.println(userName);

        String message = "";

        for(String name : main.userList.keySet()){
            if(userName.equals(name)){
                message = message + userName +"(**)\n";
            }else{
                message = message + name + "\n";
            }
        }

        System.out.println(main.userList + "Sended");

        httpExchange.sendResponseHeaders(200,message.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(message.toString().getBytes());

        outputStream.close();
    }
}
