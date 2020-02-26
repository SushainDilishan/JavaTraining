package chatServer1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class userRegistration implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        URI uri = httpExchange.getRequestURI();
        String s = uri.getRawQuery();

        String userName = s.substring(s.indexOf("=") + 1, s.length());
        System.out.println(userName);

        String meessage = "user Registered";


        if(main.userList.keySet().stream().anyMatch(userName::equals)){
            System.out.println("User Already Registered");
            meessage = "User Already Registered";
        }else{
            main.userList.put(userName,new ArrayList());
        }
        System.out.println(main.userList);

        httpExchange.sendResponseHeaders(200,meessage.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(meessage.toString().getBytes());
        outputStream.close();
    }
}
