package chatServer1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class acceptMessage implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try{
            Map<String,Object> map = new HashMap<>();
            URI uri = httpExchange.getRequestURI();
            String s = uri.getRawQuery();

            String userName = s.substring(s.indexOf("=") +1,s.length());
            System.out.println(userName);

            String message = "no";

            if ( main.userList.get(message).size() >1) {
                for (String name : main.userList.keySet()) {
                    if (name.equals(name)) {
                        name = name+ main.userList.get(name).get(1);
                        main.userList.get(name).set(1, "");
                    }
                }
            }

            System.out.println(main.userList + "Sent");

            httpExchange.sendResponseHeaders(200,message.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(message.toString().getBytes());

            outputStream.close();
        }catch (Exception e){
            System.out.println("Message Accept Fail");
            e.printStackTrace();

        }
    }
}
